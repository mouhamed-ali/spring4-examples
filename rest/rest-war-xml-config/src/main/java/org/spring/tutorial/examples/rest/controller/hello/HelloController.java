package org.spring.tutorial.examples.rest.controller.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/hello") deja mapp� dans web xml
class HelloController {
/*
 * it is not necessary to declare this class as public since we will not use it or inject it
 * in another one
 * Usually, the controller is the last in the chain of dependencies it receives HTTP requests from
 * the Spring front controller (the DispathcerServlet) and simply delegates them forward to a service layer.
 * If there is no use case where the controller has to be injected or manipulated through a direct reference,
 * then I prefer not to declare it as public.
 */

	@RequestMapping(method = RequestMethod.GET)//use @GetMapping instead of this annotation (same for other annotations)
	@ResponseBody public String sayHello() {//@ResponseBody not necessary to use with spring 4
		
		return "Hello !!!";
	}
	/*
	 * depends on the data of the request the @ResponseBody allows to select the correct MessageConverter to convert
	 * the answer to the appropriate type. for example, it looks for the property Accept in the request Http if it is equal to
	 * application/json it uses the messageConverter based on jackson which allows to convert the answer in json otherwise if
	 * the Accepet is   application/xml it uses the message converter base sue jaxb to convert the answer to the xml format
	 * but it's a simple case because it is not based on the Accept property only
	 */
	
	@RequestMapping("{name}")
	@ResponseBody public String sayHelloUserByName(@PathVariable("name") String name){
		
		return String.format("Hello %s !!!",name);
	}
/*
 * source : www.programming-free.com/2014/01/spring-mvc-40-restful-web-services.html
 * 
 * 1- all http requests will be intercepted by the dispatcher servlet mentioned in web.xml
 * 2- dispatcher servlet passes the request to the handler mapping
 * 3- the handler mapping determines the controller to be used
 * 4- Requests are now processed by the Controller and response is returned to DispatcherServlet.
 * 5- the controller returns a ModelAndView object or the name of the view. the ContentNegotiatingResolver will be used
 * to find the correct data representation
 * 6- the last step can be omitted by directly returning the data in the controller using the annotation
 * @ResponseBody
 * remarque : using the annotation Spring4 @RestController instead of @Controller we can omit the annotation
 * @ResponseBody because it is already used in the @RestController annotation.
 */
}
