package com.rk.springmavendockerbasecore.rest

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(controllers = BaseController)
class K8sResourceControllerSpec extends Specification {

    @Autowired
    MockMvc mvc

    def "should return all pods"() {
        expect:
        mvc.perform(get("/api/v1/pods"))
                .andExpect(status().isOk())
    }

    def "should return pods for specific namespace"() {
        expect:
        mvc.perform(get("/api/v1/pods?namespace=compute"))
                .andExpect(status().isOk())
    }
}
