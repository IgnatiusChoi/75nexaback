package kr.co.seoulit.account.sys.common.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//AOP 설정 할때 사용함
//meta-annotation
@Target(ElementType.TYPE) /* annotation 이 어디에 적용될 지 결정(TYPE 선언 시 사용) */
@Retention(RetentionPolicy.RUNTIME) /* annotation 이 실제로 적용되고 유지되는 범위를 의미(컴파일 이후에도 JVM에 의해 계속 참조 가능 */
public @interface Dataset {
    /* 메서드 */
    public String name();
}

/* annotation을 클래스에적용을 하고 바이트코드파일까지 annotation정보를 유지되게 한다.*/

/*
 * 	class 또는 field 에 설정된 annotation 객체를 사용하기 위해서는
	@Retention(RetentionPolicy.RUNTIME) 를 선언해야한다.

	<사용대상>
 * 	사용 대상
 	- class : @Target(ElementType.TYPE)
 	- field : @Target(ElementType.FIELD)

 	@Target 	- Constructor, Field, Enum, Local Variable, Method, Package, Parameter, Type(Class)
	@Retention 	- Source, Class, Runtime
	@Documented - annotation을 javadoc에 포함한다.
	@Inherited 	- annotation을 상속을 가능케 한다.
 */