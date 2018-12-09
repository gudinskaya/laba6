// Разработать приложение с 5 (минимум) элементами управления библиотеки
// Swing (кнопка (JButton), список (JList), текстовое поле (JTextField),
// раскрывающий список (JComboBox), текстовая область (JTextArea),
// флажок (JCheckBox), радиокнопки (JRadioButton), лэйбл (JLabel))
// исходя из задания вариантов. Подгрузку данных осуществлять из файла (при
// необходимости), сохранять данные также в файл. Обязательна реализация
// механизма закрытия окна. Также можно использовать систему подсветки
// данных, при желании.
//Оформление книги в электронной библиотеке.
//Название книги, Автор, год издания, издательство, сегодняшняя дата\ время, жанр
package org.anngudin.laba6.Library;

import java.awt.event.*;
import java.io.*;
import javax.swing.*;

public class Library extends JFrame {
    String text1;
    int someKey;
    Object boxA, boxB, boxC;
    File file = new File("GUI.txt");
    static JLabel l1, l2, l3, l4;
    JComboBox box_1, box_2, box_3;
    JRadioButton flag1, flag2;
    ButtonGroup bg;
    static JButton b, del;
    static JTextField text;
    static JTextArea area;
    static String[] box1 = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16",
            "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" };
    static String[] box2 = { "январь", "февраль", "март", "апрель", "май", "июнь", "июль", "август", "сентябрь",
            "октябрь", "ноябрь", "декабрь" };
    static String[] box3 = { "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018",
            "2019", "2020" };

    public Library(String str) {
        super(str);
        setSize(500,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b=new JButton("Внесение в базу");
        del=new JButton("Очистить");
        text=new JTextField(9);
        area=new JTextArea(9,9);
        l1=new JLabel("Название медикамента");

        l2=new JLabel("Описание лекарственных свойств");

        l3=new JLabel("Дата поступления");
        l4=new JLabel("Отпуск без рецепта");
        box_1=new JComboBox(box1);
        box_2=new JComboBox(box2);
        box_3 = new JComboBox<Object>(box3);
        flag1=new JRadioButton("да");
        flag2=new JRadioButton("нет");
        ButtonGroup bg = new ButtonGroup();
        bg.add(flag1);
        bg.add(flag2);
        setLayout(null);
        b.setSize(200,30);
        b.setLocation(150,400);
        del.setSize(100,30);
        del.setLocation(10,400);
        text.setSize(220,25);
        text.setLocation(250,20);
        area.setSize(220,150);
        area.setLocation(250,60);
        l1.setSize(200,25);
        l1.setLocation(30,20);
        l2.setSize(220,25);
        l2.setLocation(30,60);
        l3.setSize(200,25);
        l3.setLocation(30,250);
        l4.setSize(200,25);
        l4.setLocation(30,310);
        box_1.setSize(40,25);
        box_1.setLocation(250,250);
        box_2.setSize(100,25);
        box_2.setLocation(300,250);
        box_3.setSize(70,25);
        box_3.setLocation(410,250);
        flag1.setSize(40,25);
        flag1.setLocation(250,310);
        flag2.setSize(50,25);
        flag2.setLocation(300,310);
        add(b);
        add(del);
        add(text);
        add(area);

        add(l1);
        add(l2);
        add(l3);
        add(l4);
        add(box_1);
        add(box_2);
        add(box_3);
        add(flag1);
        add(flag2);
        b.addActionListener(new ButtonActionListener());

        flag1.addActionListener(new FlagActionListener());

        flag2.addActionListener(new FlagActionListener());

        del.addActionListener(new DelActionListener());
        box_1.addActionListener(new BoxActionListener());

        box_2.addActionListener(new BoxActionListener());

        box_3.addActionListener(new BoxActionListener());
    }

    public class ButtonActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            try {
                if (!file.exists()) {
                    file.createNewFile();
                }
                FileWriter out = new FileWriter(file, true);

                try {
                    String text1 = text.getText();
                    String area2 = area.getText();
                    out.write(text1 + "-");
                    out.write(area2 + "\n");
                    if (someKey == 1)
                        out.write("Отпуск медикамента осуществляется без рецепта." + "\n");
                    else if (someKey == -1)
                        out.write("Отпуск медикамента осуществляется при наличии рецепта." + "\n");

                    out.write("(Дата поступления:" + boxA + "" + boxB + "" + boxC + ")");

                } finally {
                    out.close();
                }
            } catch (IOException e1) {
                throw new RuntimeException(e1);

            }
        }
    }

    public class FlagActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            someKey = 0;
            if (e.getSource() == flag1) {
                someKey++;
            } else if (e.getSource() == flag2) {
                someKey--;
            }
        }
    }

    public class DelActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == del) {
                text.setText(null);
                area.setText(null);
            }
        }
    }

    public class BoxActionListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == box_1) {
                boxA = box_1.getSelectedItem();

            }
            if (e.getSource() == box_2) {
                boxB = box_2.getSelectedItem();
            }
            if (e.getSource() == box_3) {
                boxC = box_3.getSelectedItem();

            }
        }
    }
}