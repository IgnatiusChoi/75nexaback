package kr.co.seoulit.account.sys.common.configuration;

import com.tobesoft.xplatform.data.DataSetList;
import com.tobesoft.xplatform.data.Debugger;
import com.tobesoft.xplatform.data.PlatformData;
import com.tobesoft.xplatform.data.VariableList;
import com.tobesoft.xplatform.tx.HttpPlatformRequest;
import com.tobesoft.xplatform.tx.HttpPlatformResponse;
import com.tobesoft.xplatform.tx.PlatformType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@SuppressWarnings("deprecation")
@Component
public class XplatformInterceptor implements HandlerInterceptor {

    /*
        view 단에서 넘어온 데이터를 받아 jsp 에서 사용 가능 한 객체로 전처리(xml --> Object)
        Controller 에서 받기 전에 Interceptor 에 먼저 들어옴
    */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object Handler)
            throws Exception {
        System.out.println("XplatformInterceptor 실행");
        HttpPlatformRequest httpPlatformRequest = new HttpPlatformRequest(request); //tobesoft에서 재공한 xplatform을 사용하기 위한 객체

        //xml parsing
        //클라이언트쪽에 넘어온 xml데이터를 할당받는 부분
        httpPlatformRequest.receiveData();
        //엑플에서 transcation 요청할때 클라이언트쪽에서 넘어온 데이터를 받기 위한 platformdata
        PlatformData reqData = httpPlatformRequest.getData();

        // 서버에서 클라이언트에게 보내기 위해 객체 생성
        PlatformData resData = new PlatformData(); //tobesoft에서 재공한 xplatform을 사용하기 위한 객체

        // 클라이언트쪽에서 받앙노 데이터셋과 변수를 디버그
        debug(reqData.getDataSetList(), reqData.getVariableList());
        System.out.println("========================"+reqData.getDataSetList()+"=====================찍히는값");

        // httpservletrequest 객체에 set을 해준 뒤 컨트롤러에서 getattribute() 꺼낼 수 있다
        request.setAttribute("reqData", reqData);
        request.setAttribute("variableList", reqData.getVariableList());
        request.setAttribute("resData", resData);
       System.out.println("@@@@@@@@@@@@XplatformInterceptor preHandle메서드 종료");
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,
                                Object handler, Exception exception) throws Exception {
        PlatformData resData = (PlatformData) request.getAttribute("resData");//tobesoft에서 재공한 xplatform을 사용하기 위한 객체
        if(resData == null){
            return;
        }
        VariableList variableList = resData.getVariableList(); //tobesoft에서 재공한 xplatform을 사용하기 위한 객체
        if (exception != null) {
            exception.printStackTrace();
            variableList.add("ErrorCode", -1);
            variableList.add("ErrorMsg", exception.getMessage());
        } else {
            variableList.add("ErrorCode", 0);
            variableList.add("ErrorMsg", "success");
        }
        //tobesoft에서 재공한 xplatform을 사용하기 위한 객체
        HttpPlatformResponse httpPlatformResponse = new HttpPlatformResponse(response, PlatformType.CONTENT_TYPE_XML, "UTF-8");
        httpPlatformResponse.setData(resData);
        httpPlatformResponse.sendData();

        debug(resData.getDataSetList(), resData.getVariableList());
        resData = null;
        System.out.println("XplatformInterceptor 종료");
    }

    private void debug(DataSetList dataSetList, VariableList variableList) {
        //tobesoft에서 재공한 xplatform debug를 위한 객체
        Debugger debugger = new Debugger();
        // DEBUG - DataSet
        for (int n = 0; n < dataSetList.size(); n++) {
            System.out.println("debug11@@@@@@"+debugger.detail(dataSetList.get(n)));
        }
        // DEBUG - VariableList
        for (int n = 0; n < variableList.size(); n++) {
            System.out.println("debug22@@@@@@"+debugger.detail(variableList.get(n)));
        }
    }
}
