package com.stripes.workshop.action;

import com.stripes.workshop.entity.User;
import com.stripes.workshop.service.UserService;
import java.util.List;
import javax.inject.Inject;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

/**
 *
 * @author raf
 */
@UrlBinding("/user/{$event}")
public class UserAction extends BaseActionBean {

    private static final String JSP_LIST = "/WEB-INF/jsp/user/user-list.jsp";
    private static final String JSP_ADD = "/WEB-INF/jsp/user/user-add.jsp";
    private static final String JSP_EDIT = "/WEB-INF/jsp/user/user-edit.jsp";
    private static final String SAVE = "save";
    private static final String UPDATE = "update";

    @ValidateNestedProperties({
        @Validate(field = "name", required = true, on = {SAVE, UPDATE}, maxlength = 50)
    })
    private User user;

    @Inject
    private UserService userService;

    @DefaultHandler
    public Resolution view() {
        return new ForwardResolution(JSP_LIST);
    }

    public Resolution add() {
        return new ForwardResolution(JSP_ADD);
    }

    public Resolution edit() {
        user = userService.get(user.getId());
        return new ForwardResolution(JSP_EDIT);
    }

    public Resolution save() {
        userService.create(user);
        userService.commit();
        return new RedirectResolution(getClass());
    }

    public Resolution update() {
        userService.update(user);
        userService.commit();
        return new RedirectResolution(getClass());
    }

    public Resolution delete() {
        userService.delete(user);
        userService.commit();
        return new RedirectResolution(getClass());
    }

    public List<User> getUserList() {
        return userService.getAll();
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
