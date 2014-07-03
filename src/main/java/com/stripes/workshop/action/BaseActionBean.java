package com.stripes.workshop.action;

import java.util.logging.Logger;
import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.After;
import net.sourceforge.stripes.controller.LifecycleStage;

/**
 *
 * @author raf
 */
public class BaseActionBean implements ActionBean {

    protected ActionBeanContext context;
    protected Logger logger;

    @Override
    public ActionBeanContext getContext() {
        return context;
    }

    @Override
    public void setContext(ActionBeanContext context) {
        this.context = (ActionBeanContext) context;
    }

    @After(stages = LifecycleStage.ActionBeanResolution)
    protected void afterActionBeanResolution() {
        logger = Logger.getLogger(getClass().getSimpleName());
    }

}
