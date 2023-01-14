package com.github.liuyueyi.forum.web.front.home;

import com.github.liuyueyi.forum.web.front.home.helper.IndexRecommendHelper;
import com.github.liuyueyi.forum.web.front.home.vo.IndexVo;
import com.github.liuyueyi.forum.web.global.BaseViewController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @author YiHui
 * @date 2022/7/6
 */
@Controller
public class IndexController extends BaseViewController {
    @Autowired
    private IndexRecommendHelper indexRecommendHelper;

    @GetMapping(path = {"/", "", "/index"})
    public String index(Model model, HttpServletRequest request) {
        String activeTab = request.getParameter("category");
        IndexVo vo = indexRecommendHelper.buildIndexVo(activeTab);
        model.addAttribute("vo", vo);
        return "views/home/index";
    }

    @GetMapping(path = "test")
    public int divide() {
        return 1/0;
    }
}
