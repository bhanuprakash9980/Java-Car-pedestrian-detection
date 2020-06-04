package ramo.klevis.ml.yolo;

import lombok.extern.slf4j.Slf4j;
import ramo.klevis.ml.ui.jar;

import javax.swing.*;
import java.util.concurrent.Executors;

/**
 * Created by Klevis Ramo
 */
@Slf4j
public class RunYolo {
    private static final JFrame mainFrame = new JFrame();

    public static void main(String[] args) {

        jar progressBar = new jar(mainFrame, true);
        progressBar.showProgressBar("Loading model this make take time for the first time!");
        YoloUI yoloUi = new YoloUI();
        Executors.newCachedThreadPool().submit(() -> {
            try {

                yoloUi.initUI();
            } catch (Exception e) {
                throw new RuntimeException(e);
            } finally {
                progressBar.setVisible(false);
                mainFrame.dispose();
            }
        });
    }
}
