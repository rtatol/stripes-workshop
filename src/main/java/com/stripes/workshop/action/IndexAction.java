package com.stripes.workshop.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

/**
 *
 * @author raf
 */
@UrlBinding("/index/{$event}")
public class IndexAction extends BaseActionBean {

    private static final String JSP_INDEX = "/WEB-INF/jsp/index.jsp";
    private static final String JSP_DEV = "/WEB-INF/jsp/dev/dev.jsp";

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(JSP_INDEX);
    }

    public Resolution dev() {
        return new ForwardResolution(JSP_DEV);
    }

}
