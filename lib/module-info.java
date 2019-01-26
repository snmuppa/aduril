module com.aduril.microservices.lib { 
    exports com.aduril.microservices.lib.model to com.aduril.microservices.rest; 
    opens com.aduril.microservices.model; 
} 