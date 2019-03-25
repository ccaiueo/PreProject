package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	// 性別ステータスのラジオボタン用変数
	private Map<String, String> radioSex;

    private Map<String, String> initRadioSex() {

        Map<String, String> radio = new LinkedHashMap<>();

        // 男性、女性をMapに格納
        radio.put("男性", "false");
        radio.put("女性", "true");

        return radio;
    }

    /**
     * ホーム画面のGET用メソッド
     */
    @GetMapping("/home")
    public String getHome(Model model) {

        //コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "login/home :: home_contents");

        return "login/homeLayout";
    }

    /**
     * ユーザー一覧画面のGETメソッド用処理.
     */
    @GetMapping("/userList")
    public String getUserList(Model model) {

        //コンテンツ部分にユーザー一覧を表示するための文字列を登録
        model.addAttribute("contents", "login/userList :: userList_contents");

        //ユーザー一覧の生成
        List<User> userList = userService.selectMany();

        //Modelにユーザーリストを登録
        model.addAttribute("userList", userList);

        //データ件数を取得
        int count = userService.count();
        model.addAttribute("userListCount", count);

        return "login/homeLayout";
    }

    ////////////////////////////////////////////////////////////////////
    // このときは動いてた
    ////////////////////////////////////////////////////////////////////

    // 気にする点
    // 動的URL@PathVariable

    /*
    //ユーザー一覧画面のGET用メソッド.
    @GetMapping("/home")
    public String getHome(Model model) {

        //コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "login/home :: home_contents");

        return "login/homeLayout";
    }
    */


    ////////////////////////////////////////////////////////////////////

    /**
     * ユーザー詳細画面のGETメソッド用処理
     */
    @GetMapping("/userDetail/{id:.+}")
    public String getUserDetail(@ModelAttribute SignupForm form,
            Model model,
            @PathVariable("id") String userId) {

        // ユーザーID確認（デバッグ）
        System.out.println("userId = " + userId);

        // コンテンツ部分にユーザー詳細を表示するための文字列を登録
        model.addAttribute("contents", "login/userDetail :: userDetail_contents");

		// 性別ステータス用のラジオボタンの初期化
		radioSex = initRadioSex();

		// ラジオボタン用のMapをModelに登録
		model.addAttribute("radioSex", radioSex);

		// ユーザーIDのチェック
		if(userId != null && userId.length() > 0) {

			// ユーザー情報を取得
			User user = userService.selectOne(userId);

            // Userクラスをフォームクラスに変換
            form.setUserId(user.getUserId()); //ユーザーID
            form.setUserName(user.getUserName()); //ユーザー名
            form.setBirthday(user.getBirthday()); //誕生日
			form.setAge(user.getAge()); //年齢
            form.setSex(user.getSex()); //性別ステータス

            // Modelに登録
            model.addAttribute("signupForm", form);

        }

        return "login/homeLayout";
	}

	@PostMapping("/logout")
	public String postLogout() {

		return "redirect:/login";

	}

	// ユーザー一覧のCSV出力用メソッド
	@GetMapping("/userList/csv")
	public String getUserListCsv(Model model) {

		// 現段階では、何もせずにユーザー一覧画面に戻るだけ
		return getUserList(model);
	}

}
