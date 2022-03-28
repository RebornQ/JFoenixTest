package com.example.jfoenixtest;

import com.example.jfoenixtest.data.SearchSuggest;
import com.example.jfoenixtest.util.ResourceUtil;
import com.jfoenix.controls.JFXChipView;
import com.jfoenix.controls.JFXDefaultChip;
import com.jfoenix.controls.JFXListCell;
import javafx.beans.value.ChangeListener;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.util.StringConverter;

import java.net.URL;
import java.util.LinkedHashMap;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    public Button btSearch;
    @FXML
    public JFXChipView<SearchSuggest> productChipView;
//    public JFXChipView<SearchSuggest> appChipView;
//    public JFXChipView<SearchSuggest> partnerChipView;

    private final LinkedHashMap<String, SearchSuggest> suggestions = new LinkedHashMap<>();

    @FXML
    protected void onSearchButtonClick() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        initChipView(productChipView);
//        initChipView(appChipView);
//        initChipView(partnerChipView);
    }
    private void initChipView(JFXChipView<SearchSuggest> chipView) {
        chipView.setChipFactory((jfxChipView, entry) -> new JFXDefaultChip<>(jfxChipView, entry) {
        });
        suggestions.put("69", new SearchSuggest("69", "Test69(69)"));
        suggestions.put("1", new SearchSuggest("1", "Test1(1)"));
        suggestions.put("111", new SearchSuggest("111", "测试111(111)"));
        chipView.setConverter(new StringConverter<>() {
            @Override
            public String toString(SearchSuggest object) {
                return object.toString();
            }

            @Override
            public SearchSuggest fromString(String string) {
                return suggestions.containsKey(string) ? suggestions.get(string) : new SearchSuggest(string, "");
            }
        });
        chipView.getStylesheets().add(ResourceUtil.getResourceUrl("/css/baseView.css"));
//        chipView.getStylesheets().add(ResourceUtil.getResourceUrl("/css/jfoenix-components.css"));
        chipView.getSuggestions().addAll(suggestions.values());
        chipView.setSuggestionsCellFactory(param -> new JFXListCell<>());
        // JFXDepthManager.setDepth(productChipView, 2);
    }

}