package kr.co.seoulit.account.sys.common.mapper;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import kr.co.seoulit.account.sys.common.annotation.ColumnName;
import kr.co.seoulit.account.sys.common.annotation.Dataset;
import kr.co.seoulit.account.sys.common.annotation.Remove;
import org.apache.commons.lang.WordUtils;
import org.springframework.stereotype.Component;

import com.tobesoft.xplatform.data.DataSet;
import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.DataTypes;
import com.tobesoft.xplatform.data.PlatformData;

@Component
public class DatasetBeanMapper {
    // 넘어온 dataset 데이터를 Bean객체로 파싱
    /*
        PlatformData 안의 Dataset 을 TO, List<TO> 로 pasing (등록, 수정) 또는 반대로 동작
     */
    public <T> List<T> datasetToBeans(PlatformData reqData, Class<T> classType) throws Exception {
        String datasetName = getDataSetName(classType);
        DataSet dataset = reqData.getDataSet(datasetName);
        List<T> beanList = new ArrayList<>();
        T bean = null;
        int rowCount = dataset.getRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            bean = getBean(dataset, classType, rowIndex); // 각 로우의 값을 bean에 세팅 (insert/delete)
            beanList.add(bean);
        }
        rowCount = dataset.getRemovedRowCount(); // 삭제된 로우 수
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            bean = getDeletedBean(dataset, classType, rowIndex);
            beanList.add(bean);
        }
        return beanList;
    }

    public <T> T datasetToBean(PlatformData reqData, Class<T> classType) throws Exception {
        T bean = null;
        String datasetName = getDataSetName(classType);
        System.out.println("                                  datasetToBean :" + datasetName);
        DataSet dataset = reqData.getDataSet(datasetName);
        System.out.println("                                  dataset :" + dataset);
        if(dataset.getRemovedRowCount() == 0) // 삭제하는 행의 수. 삭제 데이터가 없을 경우.
            bean = getBean(dataset, classType, 0); // dataset -> Bean / dataset 로우가 하나니까 index를 그냥 0으로 보내는 듯
        else
            bean = getDeletedBean(dataset, classType, 0);
        return bean;
    }

    public <T> void beansToDataset(PlatformData resData, List<T> beanList, Class<T> classType) throws Exception {
        Map<String, String> nameMap = new HashMap<String, String>();
        DataSetList datasetList = resData.getDataSetList();
        String datasetName = getDataSetName(classType);
        DataSet dataset = new DataSet(datasetName);
        datasetList.add(dataset);

        System.out.println("datasetList :"+datasetList);
        System.out.println("datasetName :"+datasetName);
        System.out.println("dataset :"+ dataset);

        Field[] fields = classType.getDeclaredFields();
        for(Field field : fields) {
            setColumnName(dataset, nameMap, field);
        }
        System.out.println("@@@@@@@@@ :"+ dataset);
        for(T bean : beanList) {
            setColumnValue(dataset, nameMap, bean);
        }
        System.out.println("######### :"+ dataset);
    }


    public <T> void beanToDataset(PlatformData resData, T bean, Class<T> classType) throws Exception {
        Map<String, String> nameMap = new HashMap<String, String>();
        DataSetList datasetList = resData.getDataSetList();
        String datasetName = getDataSetName(classType); // 해당 TO와 매핑되는 Dataset 정보
        DataSet dataset = new DataSet(datasetName);
        datasetList.add(dataset);

        if(bean != null) {
            Field[] fields = classType.getDeclaredFields(); // 해당 TO에 선언된 필드
            for(Field field : fields)
                setColumnName(dataset, nameMap, field); // 칼럼명 세팅
            setColumnValue(dataset, nameMap, bean); // 값 세팅
        }
    }

    public void mapToDataset(PlatformData resData, List<Map<String, Object>> mapList, String datasetName) throws Exception {
        DataSetList datasetList = resData.getDataSetList();
        DataSet dataset = new DataSet(datasetName);
        datasetList.add(dataset);

        for(String key : mapList.get(0).keySet()) {
            String columnName = key.toLowerCase();
            dataset.addColumn(columnName, DataTypes.STRING, 256);
        }

        int rowIndex = 0;
        for(Map<String, Object> map : mapList) {
            rowIndex = dataset.newRow();
            for(String key : map.keySet()) {
                Object columnValue = map.get(key);
                dataset.set(rowIndex, key.toLowerCase(), columnValue);
            }
        }
    }

    public List<Map<String, Object>> datasetToMap(PlatformData reqData, String datasetName) throws Exception {
        List<Map<String, Object>> mapList = new ArrayList<>();
        DataSet dataset = reqData.getDataSet(datasetName);
        int rowCount = dataset.getRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", dataset.getRowTypeName(rowIndex));

            for(int colIndex = 0; colIndex < dataset.getColumnCount(); colIndex++) {
                String key = dataset.getColumn(colIndex).getName();
                Object value = dataset.getObject(rowIndex, key);
                map.put(formattingToCamel(key), value);
            }
            mapList.add(map);
        }
        rowCount = dataset.getRemovedRowCount();
        for(int rowIndex = 0; rowIndex < rowCount; rowIndex++) {
            Map<String, Object> map = new HashMap<>();
            map.put("status", dataset.getRowTypeName(rowIndex));

            for(int colIndex = 0; colIndex < dataset.getColumnCount(); colIndex++) {
                String key = dataset.getColumn(colIndex).getName();
                Object value = dataset.getObject(rowIndex, key);
                map.put(formattingToCamel(key), value);
            }
            mapList.add(map);
        }
        return mapList;
    }

    private <T> String getDataSetName(Class<T> classType) {
        if(classType.isAnnotationPresent(Dataset.class))
            return classType.getAnnotation(Dataset.class).name();
        else
            return "ds" + classType.getName().replace("Bean", "");
    }

    private String getColumnName(Method method) {
        String columnName = null;
        Annotation[] annotations = method.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof ColumnName) { // 해당 메서드에 ColumnName 어노테이션이 적용되어 있다면
                String annotaionName = ((ColumnName) annotation).name(); // name값 즉 필드와 매핑되는 칼럼명
                columnName = annotaionName;
            }
        }
        if (annotations.length == 0)  // 어노테이션이 없으면
            columnName = formattingToSnake(method.getName()); // 메서드명을 스네이크표기법으로 변환
        return columnName;
    }

    private void setColumnName(DataSet dataset, Map<String, String> nameMap, Field field) { // 생성한 Dataset 객체에 Column 세팅
        ColumnName column = field.getAnnotation(ColumnName.class); // 어노테이션 객체 가져옴
        Remove remove = field.getAnnotation(Remove.class); // 어노테이션 객체 가져옴

        if(column != null) { // 칼럼명을 직접 정해준 경우
            dataset.addColumn(column.name(), getDataType(field)); // dataset에 해당 이름의 칼럼 생성. 칼럼의 이름과 칼럼의 타입.
            nameMap.put(column.name(), field.getName()); // 매핑되는 칼럼명과 필드명 정보
        } else if(column == null && remove == null) { // 어노테이션 적용 안된 경우
            String columnName = formattingToSnake(field.getName()); // 필드명을 스네이크 표기법, 대문자로 변환한다. abCdEf -> AB_CD_EF
            dataset.addColumn(columnName, getDataType(field));
            nameMap.put(columnName, field.getName());
        }
        // @Remove 적용된 경우 아무 작업도 하지 앟음
    }

    private <T> void setColumnValue(DataSet dataset, Map<String, String> nameMap, T bean) throws Exception {
        int rowIndex = dataset.newRow();
        for(String columnName : nameMap.keySet()) { // 칼럼명이 세팅되어있다.
            String fieldName = nameMap.get(columnName); // 매핑되는 필드명 구함
            Field value = bean.getClass().getDeclaredField(fieldName.trim()); // 필드 객체 구함
            value.setAccessible(true);                           // Priavte 로 되어있는 객체에 접근하기 위해서 사용
            dataset.set(rowIndex, columnName, value.get(bean));         // 해당 로우의 해당 칼럼에, 해당 값을 세팅한다.
            // Field.get() : 지정된 개체에서 이 Field가 나타내는 필드의 값을 반환
        }
    }

    private <T> T getBean(DataSet dataset, Class<T> classType, int rowIndex) throws Exception {
        @SuppressWarnings("deprecation")
        T bean = classType.newInstance();
        Method[] methods = classType.getDeclaredMethods();
        Method statusMethod = classType.getMethod("setStatus", String.class);
        String rowType = null;
        switch(dataset.getRowTypeName(rowIndex)){ // rowIndex = 0 / 해당 row의 타입이 넘어오나보다.
            case "inserted" :
                rowType = "insert";
                break;
            case "updated" :
                rowType = "update";
                break;
        }
        statusMethod.invoke(bean, rowType); // bean에 status 세팅
        for(Method method : methods) {
            if(method.getName().startsWith("set")) {
                String columnName = getColumnName(method); // method명을 통해 칼럼명을 구한다.
                System.out.println("columnName : "+columnName);
                if(columnName != null) {
                    Object columnValue = dataset.getObject(rowIndex, columnName); // 해당 로우의 해당 칼럼의 값
                    System.out.println("columnValue : "+columnValue);
                    if(columnValue != null)
                        method.invoke(bean, columnValue); // bean의 필드에, 매핑되는 각 칼럼의 값을 세팅
                }
            }
        }
        return bean;
    }

    private <T> T getDeletedBean(DataSet dataset, Class<T> classType, int rowIndex) throws Exception {
        @SuppressWarnings("deprecation")
        T bean = classType.newInstance();
        Method[] methods = classType.getDeclaredMethods();
        Method statusMethod = classType.getMethod("setStatus", String.class);
        statusMethod.invoke(bean, "delete");
        for (Method method : methods) {
            if (method.getName().startsWith("set")) {
                String columnName = getColumnName(method);
                if (columnName != null) {
                    Object columnValue = dataset.getRemovedData(rowIndex, columnName);
                    if (columnValue != null)
                        method.invoke(bean, columnValue);
                }
            }
        }
        return bean;
    }
    private int getDataType(Field field) {
        Class<?> returnType = field.getType();
        if(returnType == Date.class)
            return DataTypes.DATE;
        else if(returnType == String.class)
            return DataTypes.STRING;
        else if(returnType == int.class || returnType == boolean.class)
            return DataTypes.INT;
        else if(returnType == BigDecimal.class)
            return DataTypes.BIG_DECIMAL;
        else if(returnType == double.class )
            return DataTypes.DOUBLE;
        else if(returnType == byte[].class)
            return DataTypes.BLOB;
        else
            return DataTypes.NULL;
    }

    private String formattingToSnake(String name) {
        String regex = "([a-z])([A-Z])";
        String replacement = "$1_$2";
        if(name.startsWith("set") || name.startsWith("get"))
            name = name.substring(3);
        // aA -> a_A
        name = name.replaceAll(regex, replacement);
        // return A_A
        return name.toUpperCase();
    }

    private String formattingToCamel(String name) {
        if(name.startsWith("set") || name.startsWith("get"))
            name = name.substring(3);
        String camel = WordUtils.capitalizeFully(name, new char[]{'_'}).replaceAll("_", "");
        return camel.substring(0, 1).toLowerCase() + camel.substring(1);
    }
}
