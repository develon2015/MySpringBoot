package develon.spring.emcat

import com.fasterxml.jackson.databind.SerializationFeature
import develon.spring.log.log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.context.event.ApplicationStartedEvent
//import org.springframework.context.ApplicationContext
import org.springframework.context.annotation.Configuration
import org.springframework.context.event.EventListener
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter

/**
 * 配置类
 *
 * 监听ApplicationStartedEvent, 打印消息转换器, 配置Jackson格式
 *
 * 示例:
 * ```Java
 * @SpringBootApplication(scanBasePackageClasses = { DemoApplication.class, EventListener.class })
 * public class DemoApplication {
 * 	public static void main(String[] args) {
 * 		SpringApplication.run(DemoApplication.class, args);
 * 	}
 * }
 *```
 */
@Configuration
open class EventListener {
	//	@Autowired val webApplicationContext: ApplicationContext? = null
	@Autowired val requestMappingHandlerAdapter: RequestMappingHandlerAdapter? = null
	@Autowired val mappingJackson2HttpMessageConverter: MappingJackson2HttpMessageConverter? = null

	@EventListener fun onStarted(event: ApplicationStartedEvent) {
//	    val requestMappingHandlerAdapter = mWebApplicationContext!!.getBean(RequestMappingHandlerAdapter::class.java)
		val messageConverters = requestMappingHandlerAdapter!!.messageConverters
		val sb = StringBuilder(10240)
		sb.append("Spring共加载了 ${ messageConverters.size } 个消息转换器对象:\n")
		for (mc in messageConverters)
			sb.append("${mc::class.java.canonicalName}\n")
		log.d(sb.toString().dropLastWhile { it == '\n' })
		mappingJackson2HttpMessageConverter!!.objectMapper.enable(SerializationFeature.INDENT_OUTPUT)
	}
}