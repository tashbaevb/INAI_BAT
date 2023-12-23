package com.example.inai_bat.service;

import java.util.Random;

public class TextAnimator implements Runnable {

    private String text;
    private float animationTime;
    private TextOutput textOutput;
    private Random random = new Random();

    public TextAnimator(String text, double animationTime, TextOutput textField) {
        this.text = text;
        this.animationTime = (float) animationTime;
        this.textOutput = textField;
    }

    @Override
    public void run() {

        try {
            for (int i = 0; i <= text.length(); i++) {
                String textAtThisPoint = text.substring(0, i);

                textOutput.writeText(textAtThisPoint);
                Thread.sleep((long) (animationTime + random.nextInt(150)));
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
