package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.formbean.UserInfo;
import com.example.demo.login.domain.model.SignupForm;
import com.example.demo.login.domain.model.User;
import com.example.demo.login.domain.service.UserService;

@Controller
@SessionAttributes("userInfo")
public class SignupController {

    /**
     *  <b>セッション処理用のメソッド.</b><br>
     * @param userInfo ユーザー情報
     * @return ユーザー情報
     */
    @ModelAttribute("userInfo")
    public UserInfo setUserInfo(UserInfo userInfo){
        return userInfo;
    }

    @Autowired
    private UserService userService;

    //ラジオボタン用変数
    private Map<String, String> radioSex;

    /**
     * ラジオボタンの初期化メソッド.
     */
    private Map<String, String> initRadioSex() {

        Map<String, String> radio = new LinkedHashMap<>();

        // 男性、女性をMapに格納
        radio.put("男性", "false");
        radio.put("女性", "true");

        return radio;
    }

    /**
     * ユーザー登録画面のGETメソッド用処理.
     */
    @GetMapping("/signup")
    public String getSignUp(@ModelAttribute SignupForm form, Model model) {

        // ラジオボタンの初期化メソッド呼び出し
        radioSex = initRadioSex();

        // ラジオボタン用のMapをModelに登録
        model.addAttribute("radioSex", radioSex);

        // signup.htmlに画面遷移
        return "login/signup";
    }

    /**
     * ユーザー登録画面のPOSTメソッド用処理.
     */
    @PostMapping("/signup")
    // バリデーション(順番あり版)
    //public String postSignUp(@ModelAttribute @Validated(GroupOrder.class) SignupForm form,

    // バリデーション(順番なし版)
    public String postSignUp(@ModelAttribute @Validated SignupForm form,
            BindingResult bindingResult,
            Model model) {

        // 入力チェックに引っかかった場合、ユーザー登録画面に戻る
        if (bindingResult.hasErrors()) {

            // GETリクエスト用のメソッドを呼び出して、ユーザー登録画面に戻ります
            return getSignUp(form, model);

        }

        // formの中身をコンソールに出して確認します
        System.out.println(form);

        // insert用変数
        User user = new User();

        user.setUserId(form.getUserId()); //ユーザーID
        user.setUserName(form.getUserName()); //ユーザー名
        user.setPassword(form.getPassword()); //パスワード
        user.setBirthday(form.getBirthday()); //誕生日
        user.setAge(form.getAge()); //年齢
        user.setSex(form.isSex()); //結婚ステータス
        user.setRole("ROLE_GENERAL"); //ロール（一般）

        // ユーザー登録処理
        boolean result = userService.insert(user);

        // ユーザー登録結果の判定
        if (result == true) {
            System.out.println("insert成功");
        } else {
            System.out.println("insert失敗");
        }


        // login.htmlにリダイレクト
        return "redirect:/test";
    }





}