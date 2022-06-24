package btl.component;

import btl.Global;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputSelect extends InputScript {
    private JComboBox<String> jComboBox;
    private List<OptionSelect> optionSelectList;

    public InputSelect(List<OptionSelect> list) {
        this.optionSelectList = list;
        jComboBox = new JComboBox<>(
                Global.convertToArrString(list.stream().map(i -> i.label).collect(Collectors.toList()))
        );
        add(jComboBox);
//        super((String[]) Global.convertToArr(items.stream().map(i -> i.label).collect(Collectors.toList())));
    }

    public InputSelect(OptionSelect[] list) {
        this.optionSelectList = new ArrayList<>();
        this.optionSelectList.addAll(Arrays.asList(list));

        jComboBox = new JComboBox<>(
                Global.convertToArrString(
                        this.optionSelectList
                                .stream().map(i -> i.label)
                                .collect(Collectors.toList())));
        add(jComboBox);
//        super((String[]) Global.convertToArr(items.stream().map(i -> i.label).collect(Collectors.toList())));
    }


    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        jComboBox.setBounds(0, 0, width, height);
        repaint();
    }

    @Override
    public String getText() {
        return optionSelectList.get(jComboBox.getSelectedIndex()).value + "";
    }

    @Override
    public Integer getInt() {
        return optionSelectList.get(jComboBox.getSelectedIndex()).value;
    }

    @Override
    public void setText(String text) {

    }
}
