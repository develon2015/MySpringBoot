package develon.spring.emcat

import develon.spring.log.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.ContextRefreshedEvent
import org.springframework.context.event.EventListener
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

@Configuration
open class EventListener {
	@Autowired var mWebApplicationContext: ApplicationContext? = null

	@EventListener fun onStarted(event: ContextRefreshedEvent) {
	    val requestMappingHandlerAdapter = mWebApplicationContext!!.getBean(RequestMappingHandlerAdapter::class.java);
	    val messageConverters = requestMappingHandlerAdapter.getMessageConverters();
	    val sb = StringBuilder(1024);
	    sb.append("Spring共加载了 ${ messageConverters.size } 个消息转换器对象:\n");
	    for (mc in messageConverters) {
	    	sb.append(mc::class.java.getCanonicalName());
	    	sb.append("\n");
	    }
		log.d(sb.toString())
	}
}