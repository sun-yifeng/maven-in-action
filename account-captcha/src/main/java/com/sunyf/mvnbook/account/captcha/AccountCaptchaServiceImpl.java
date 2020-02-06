package com.sunyf.mvnbook.account.captcha;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

import javax.imageio.ImageIO;

import org.springframework.beans.factory.InitializingBean;

//import com.google.code.kaptcha.impl.DefaultKaptcha;
//import com.google.code.kaptcha.util.Config;

// 实现了SpringFramework的InitializingBean接口
public class AccountCaptchaServiceImpl implements AccountCaptchaService, InitializingBean {

    //private DefaultKaptcha producer; //验证码生成器

    private Map<String, String> captchaMap = new HashMap<String, String>();

    private List<String> preDefinedTexts; //验证码字符串g

    private int textCount = 0;

    /*Spring初始化Bean对象的时候调用此方法
    public void afterPropertiesSet() throws Exception {
        producer = new DefaultKaptcha();
        producer.setConfig(new Config(new Properties()));
    }*/

    //生成随机验证码
    public String generateCaptchaKey() {

        String key = RandomGenerator.getRandomString();

        String value = getCaptchaText();

        captchaMap.put(key, value);

        return key;
    }

    public List<String> getPreDefinedTexts() {
        return preDefinedTexts;
    }

    //验证码字符串set方法
    public void setPreDefinedTexts(List<String> preDefinedTexts) {
        this.preDefinedTexts = preDefinedTexts;
    }

    //验证码字符串get方法
    private String getCaptchaText() {
        if (preDefinedTexts != null && !preDefinedTexts.isEmpty()) {
            String text = preDefinedTexts.get(textCount);
            textCount = (textCount + 1) % preDefinedTexts.size();
            return text;
        } else {
            //return producer.createText();
            return null;
        }

    }

    //生成验证码图片
    public byte[] generateCaptchaImage(String captchaKey) throws AccountCaptchaException {

        String text = captchaMap.get(captchaKey);

        if (text == null) {
            throw new AccountCaptchaException("Captch key '" + captchaKey + "' not found!");
        }

        //BufferedImage image = producer.createImage(text);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        /*
        try {
            ImageIO.write(image, "jpg", out);
        } catch (IOException e) {
            throw new AccountCaptchaException("Failed to write captcha stream!", e);
        }*/

        return out.toByteArray();
    }

    //验证码的验证
    public boolean validateCaptcha(String captchaKey, String captchaValue) throws AccountCaptchaException {

        String text = captchaMap.get(captchaKey);
        if (text == null) {
            throw new AccountCaptchaException("Captch key '" + captchaKey + "' not found!");
        }

        if (text.equals(captchaValue)) {
            captchaMap.remove(captchaKey);
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void afterPropertiesSet() throws Exception {

    }
}
