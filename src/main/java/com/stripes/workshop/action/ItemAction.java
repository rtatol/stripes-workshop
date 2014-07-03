package com.stripes.workshop.action;

import com.stripes.workshop.entity.Item;
import com.stripes.workshop.entity.User;
import com.stripes.workshop.service.ItemService;
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
@UrlBinding("/item/{$event}")
public class ItemAction extends BaseActionBean {

    private static final String JSP_LIST = "/WEB-INF/jsp/item/item-list.jsp";
    private static final String JSP_ADD = "/WEB-INF/jsp/item/item-add.jsp";
    private static final String JSP_EDIT = "/WEB-INF/jsp/item/item-edit.jsp";
    private static final String SAVE = "save";
    private static final String UPDATE = "update";

    @ValidateNestedProperties({
        @Validate(field = "name", required = true, on = {SAVE, UPDATE}, maxlength = 30),
        @Validate(field = "price", required = true, on = {SAVE, UPDATE}, minvalue = 0, maxvalue = Double.MAX_VALUE)
    })
    private Item item;

    @Inject
    private ItemService itemService;
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
        item = itemService.get(item.getId());
        return new ForwardResolution(JSP_EDIT);
    }

    public Resolution save() {
        itemService.create(item);
        itemService.commit();
        return new RedirectResolution(getClass());
    }

    public Resolution update() {
        itemService.update(item);
        itemService.commit();
        return new RedirectResolution(getClass());
    }

    public Resolution delete() {
        itemService.delete(item);
        itemService.commit();
        return new RedirectResolution(getClass());
    }

    public List<Item> getItemList() {
        return itemService.getAll();
    }

    public List<User> getUserList() {
        return userService.getAll();
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

}
