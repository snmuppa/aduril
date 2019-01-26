module com.aduril.microservices.rest { 
    requires spring.core; 
    requires spring.beans; 
    requires spring.context; 
    requires spring.aop; 
    requires spring.web; 
    requires spring.expression; 
 
    requires spring.boot; 
    requires spring.boot.autoconfigure; 
 
    requires com.aduril.microservices.lib; 
 
    exports com.aduril.microservices.rest; 
    exports com.aduril.microservices.rest.resources; 
 
    opens com.aduril.microservices.rest; 
    opens com.aduril.microservices.rest.resources; 
} 