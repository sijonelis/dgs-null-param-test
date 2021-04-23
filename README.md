Repro steps:
1. Run project
2. Navigate to localhost:8080/graphiql
3. goodQuery (defined in TestResolver) will run without issues
```
{
  goodQuery(filter:null, size:10, page:1, sort:null)
}
```
4. badQuery will fail 
```
{
  badQuery(filter:null, size:10, page:1, sort:null)
}
```
with 
```n
java.lang.NullPointerException: environment.getArgument(parameterNames[idx]) must not be null
	at com.netflix.graphql.dgs.internal.DgsSchemaProvider.invokeDataFetcher(DgsSchemaProvider.kt:386) ~[graphql-dgs-3.11.0.jar:3.11.0]
	at com.netflix.graphql.dgs.internal.DgsSchemaProvider.access$invokeDataFetcher(DgsSchemaProvider.kt:64) ~[graphql-dgs-3.11.0.jar:3.11.0]
	at com.netflix.graphql.dgs.internal.DgsSchemaProvider$createBasicDataFetcher$1.get(DgsSchemaProvider.kt:279) ~[graphql-dgs-3.11.0.jar:3.11.0]
	at graphql.execution.ExecutionStrategy.fetchField(ExecutionStrategy.java:270) ~[graphql-java-16.2.jar:na]
	at graphql.execution.ExecutionStrategy.resolveFieldWithInfo(ExecutionStrategy.java:203) ~[graphql-java-16.2.jar:na]
	at graphql.execution.AsyncExecutionStrategy.execute(AsyncExecutionStrategy.java:60) ~[graphql-java-16.2.jar:na]
	at graphql.execution.Execution.executeOperation(Execution.java:165) ~[graphql-java-16.2.jar:na]
	at graphql.execution.Execution.execute(Execution.java:104) ~[graphql-java-16.2.jar:na]
	at graphql.GraphQL.execute(GraphQL.java:557) ~[graphql-java-16.2.jar:na]
	at graphql.GraphQL.parseValidateAndExecute(GraphQL.java:482) ~[graphql-java-16.2.jar:na]
	at graphql.GraphQL.executeAsync(GraphQL.java:446) ~[graphql-java-16.2.jar:na]
	at graphql.GraphQL.execute(GraphQL.java:377) ~[graphql-java-16.2.jar:na]
	at com.netflix.graphql.dgs.internal.DefaultDgsQueryExecutor.execute(DefaultDgsQueryExecutor.kt:116) ~[graphql-dgs-3.11.0.jar:3.11.0]
	at com.netflix.graphql.dgs.mvc.DgsRestController$graphql$executionResult$1.invoke(DgsRestController.kt:165) ~[graphql-dgs-spring-webmvc-3.11.0.jar:3.11.0]
	at com.netflix.graphql.dgs.mvc.DgsRestController$graphql$executionResult$1.invoke(DgsRestController.kt:65) ~[graphql-dgs-spring-webmvc-3.11.0.jar:3.11.0]
	at com.netflix.graphql.dgs.internal.utils.TimeTracer.logTime(TimeTracer.kt:24) ~[graphql-dgs-3.11.0.jar:3.11.0]
	at com.netflix.graphql.dgs.mvc.DgsRestController.graphql(DgsRestController.kt:163) ~[graphql-dgs-spring-webmvc-3.11.0.jar:3.11.0]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method) ~[na:na]
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62) ~[na:na]
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43) ~[na:na]
	at java.base/java.lang.reflect.Method.invoke(Method.java:566) ~[na:na]
	at org.springframework.web.method.support.InvocableHandlerMethod.doInvoke(InvocableHandlerMethod.java:197) ~[spring-web-5.3.6.jar:5.3.6]
	at org.springframework.web.method.support.InvocableHandlerMethod.invokeForRequest(InvocableHandlerMethod.java:141) ~[spring-web-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.mvc.method.annotation.ServletInvocableHandlerMethod.invokeAndHandle(ServletInvocableHandlerMethod.java:106) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.invokeHandlerMethod(RequestMappingHandlerAdapter.java:894) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter.handleInternal(RequestMappingHandlerAdapter.java:808) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.mvc.method.AbstractHandlerMethodAdapter.handle(AbstractHandlerMethodAdapter.java:87) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.DispatcherServlet.doDispatch(DispatcherServlet.java:1060) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.DispatcherServlet.doService(DispatcherServlet.java:962) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.FrameworkServlet.processRequest(FrameworkServlet.java:1006) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at org.springframework.web.servlet.FrameworkServlet.doPost(FrameworkServlet.java:909) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:517) ~[jakarta.servlet-api-4.0.4.jar:4.0.4]
	at org.springframework.web.servlet.FrameworkServlet.service(FrameworkServlet.java:883) ~[spring-webmvc-5.3.6.jar:5.3.6]
	at javax.servlet.http.HttpServlet.service(HttpServlet.java:584) ~[jakarta.servlet-api-4.0.4.jar:4.0.4]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:227) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.tomcat.websocket.server.WsFilter.doFilter(WsFilter.java:53) ~[tomcat-embed-websocket-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.springframework.web.filter.RequestContextFilter.doFilterInternal(RequestContextFilter.java:100) ~[spring-web-5.3.6.jar:5.3.6]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.3.6.jar:5.3.6]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.springframework.web.filter.FormContentFilter.doFilterInternal(FormContentFilter.java:93) ~[spring-web-5.3.6.jar:5.3.6]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.3.6.jar:5.3.6]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.springframework.web.filter.CharacterEncodingFilter.doFilterInternal(CharacterEncodingFilter.java:201) ~[spring-web-5.3.6.jar:5.3.6]
	at org.springframework.web.filter.OncePerRequestFilter.doFilter(OncePerRequestFilter.java:119) ~[spring-web-5.3.6.jar:5.3.6]
	at org.apache.catalina.core.ApplicationFilterChain.internalDoFilter(ApplicationFilterChain.java:189) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.ApplicationFilterChain.doFilter(ApplicationFilterChain.java:162) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.StandardWrapperValve.invoke(StandardWrapperValve.java:202) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.StandardContextValve.invoke(StandardContextValve.java:97) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.authenticator.AuthenticatorBase.invoke(AuthenticatorBase.java:542) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.StandardHostValve.invoke(StandardHostValve.java:143) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.valves.ErrorReportValve.invoke(ErrorReportValve.java:92) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.core.StandardEngineValve.invoke(StandardEngineValve.java:78) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.catalina.connector.CoyoteAdapter.service(CoyoteAdapter.java:357) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.coyote.http11.Http11Processor.service(Http11Processor.java:374) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.coyote.AbstractProcessorLight.process(AbstractProcessorLight.java:65) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.coyote.AbstractProtocol$ConnectionHandler.process(AbstractProtocol.java:893) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.tomcat.util.net.NioEndpoint$SocketProcessor.doRun(NioEndpoint.java:1707) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at org.apache.tomcat.util.net.SocketProcessorBase.run(SocketProcessorBase.java:49) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at java.base/java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1128) ~[na:na]
	at java.base/java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:628) ~[na:na]
	at org.apache.tomcat.util.threads.TaskThread$WrappingRunnable.run(TaskThread.java:61) ~[tomcat-embed-core-9.0.45.jar:9.0.45]
	at java.base/java.lang.Thread.run(Thread.java:834) ~[na:na]
```