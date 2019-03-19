package com.example.demo.login.controller;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignupController {

    //ラジオボタン用変数
    private Map<String, String> radioSex;

    /**
     * ラジオボタンの初期化メソッド.
     */
    private Map<String, String> initRadioSex() {

        Map<String, String> radio = new LinkedHashMap<>();

        // 男性、女性をMapに格納
        radio.put("男", "true");
        radio.put("女", "false");

        return radio;
    }

    /**
     * ユーザー登録画面のGETメソッド用処理.
     */
    @GetMapping("/signup")
    public String getSignUp(Model model) {

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
    public String postSignUp(Model model) {

        // login.htmlにリダイレクト
        return "redirect:/test";
    }
}