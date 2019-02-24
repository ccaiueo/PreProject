package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.ProjectApplication;
import com.example.demo.formbean.UserInfo;
import com.example.demo.service.DBService;

/**
 * <b>トップControllerクラス.</b><br>
 * @author erika
 *
 */
@Controller
@SessionAttributes("userInfo")
public class AdminController {

	// メモ 返り値をStringにする時はModelAndViewではなくModelを使う。

	/** DB関連Serviceクラス. */
	@Autowired
	private DBService service;

	/** 遷移先URL. */
	class PAGE {
		/** index画面URL */
		public static final String INDEX = "index";
		/** session登録完了画面URL */
		public static final String SESSION_REGISTERD = "blank";
		/** logout画面URL */
		public static final String LOGOUT = "logout";
	}

    /**
     *  <b>セッション処理用のメソッド.</b><br>
     * @param userInfo ユーザー情報
     * @return ユーザー情報
     */
    @ModelAttribute("userInfo")
    public UserInfo setUserInfo(UserInfo userInfo){
        return userInfo;
    }

    /**
     * <b>Admin機能初期化.</b><br>
     * ダッシュボード画面へ遷移し初期表示を行う。
     * @param model viewへ渡すオブジェクト設定クラス
     * @return 遷移先URL
     */
    @RequestMapping(value="admin/dashboard", method=RequestMethod.GET)
    public String dashboard(Model model) {

    	// プロパティファイル出力テスト
    	System.out.println(ProjectApplication.propertiesMap.toString());

    	// メニュー用
    	model.addAttribute("dashboard", "active");
        return PAGE.INDEX;
    }

    /**
     * <b>Tweetボタン押下.</b><br>
     * @param tweet テスト値
     * @param model viewへ渡すオブジェクト設定クラス
     * @return 遷移先URL
     */
    @RequestMapping(value="admin/sec", method=RequestMethod.POST)
    public String sec(@ModelAttribute ("tweet") String tweet, Model model) {


    	// メニューCSS用
    	model.addAttribute("dashboard", "active");
    	// JSPからわたってきた値
        model.addAttribute("tweet", tweet);

        System.out.println("SEC");
        return PAGE.INDEX;
    }

    /**
     * <b>Register押下.</b><br>
     * セッション設定を行い、セッション登録完了画面へ遷移する。
     * @param name 画面から受け取った値
     * @param userInfo セッション格納値
     * @param model viewへ渡すオブジェクト設定クラス
     * @return 遷移先URL
     */
    @RequestMapping(value="admin/session", method=RequestMethod.POST)
    public String session(@ModelAttribute("userInfo") UserInfo userInfo, Model model) {

    	System.out.println("SESSION");

    	// sessionに格納
    	// sessionはmodelへaddしなくても取れる？
    	// setもいらない？
//    	setUserInfo(userInfo);

        return PAGE.SESSION_REGISTERD;
    }

    /**
     * <b>セッションクローズ.</b><br>
     * セッションを破棄する。
     * @param sessionStatus セッション管理クラス
     * @return 遷移先URL
     */
    @RequestMapping(value="admin/close", method=RequestMethod.POST)
    public String sessionClose(SessionStatus sessionStatus) {
        sessionStatus.setComplete();
        return PAGE.LOGOUT;

    }

    /**
     * <b>cards画面へ遷移する.</b><br>
     * @param model viewへ渡すオブジェクト設定クラス
     * @return 遷移先URL
     */
    @RequestMapping(value="admin/cards", method=RequestMethod.POST)
    public String cards(Model model) {
    	// メニューCSS用
    	model.addAttribute("components", "active");
    	model.addAttribute("pages", "active");
    	model.addAttribute("customComponents", "show");
        return "cards";

    }

    /**
     * <b>createTicket画面へ遷移する.</b><br>
     * @param model viewへ渡すオブジェクト設定クラス
     * @return 遷移先URL
     */
    @RequestMapping(value="admin/create/ticket", method=RequestMethod.POST)
    public String create(Model model) {

    	model.addAttribute("ticketInfoList", service.getTicketInfo());

    	// メニュー用
    	model.addAttribute("showCategory", "show");
    	model.addAttribute("activeCreate", "active");
    	model.addAttribute("activeTiclet", "active");
        return "createTicket";

    }

//    // Mybatis
//    System.out.println("mapper(xml): " + service.get());
//    System.out.println("mapper(@) : " + service.select());

}
