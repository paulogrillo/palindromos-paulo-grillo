package com.bradesco.app.core.usecase.util.log;

import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import com.fasterxml.jackson.databind.node.ObjectNode;
import lombok.Builder;
import org.codehaus.plexus.util.StringUtils;
import org.slf4j.Logger;

@Builder(builderMethodName = "hiddenBuilder")
public class LogUtil {

    private Logger logger;
    private LogFlow flow;
    private String errorCode;
    private String errorCodeMessage;

    public static LogUtilBuilder builder(Logger logger, LogFlow flow) {
        return hiddenBuilder().logger(logger).flow(flow);
    }

    public void logErrorJson(Exception exception) {
        ObjectNode jsonNode = JsonNodeFactory.instance.objectNode();

        addJsonNode(jsonNode, "flow", flow.name());
        addJsonNode(jsonNode, "errorCode", errorCode);
        addJsonNode(jsonNode, "errorCodeMessage", errorCodeMessage);

    }

    private void addJsonNode(ObjectNode node, String identifier, String value){
        if(!StringUtils.isEmpty(value)){
            node.put(identifier, value);
        }
    }


}
