package org.anngudin.laba6.LibraryWindow;

import javax.swing.*; 
import java.awt.event.ActionEvent; 
import java.awt.event.ActionListener; 
import java.io.File; 
import java.io.FileWriter; 
import java.io.IOException; 
 
public class LibraryWindow extends JFrame { 
    int key; 
    static JButton saveButton; 
    static JTextField email; 
    static JTextField bookName; 
    static JTextField author; 
    static JLabel emailLabel, bookNameLabel,authorLabel, bookTypeLabel, newsLabel; 
    static JRadioButton poetryRadioButton,proseRadioButton; 
    static JCheckBox everyDay, everyMonth, everyWeek; 
 
    public LibraryWindow(){ 

        super("Book registration in the online library"); 
        JPanel panel = new JPanel(); 
        panel.setLayout(null); 
 
    
        emailLabel = new JLabel("Enter your email");
        email = new JTextField(8); 

        bookNameLabel = new JLabel("Enter the title of the book");
        bookName = new JTextField(8); 

        authorLabel = new JLabel("Enter the author"); 
        author = new JTextField(8);

        bookTypeLabel = new JLabel("Choose the type"); 
        poetryRadioButton = new JRadioButton("Poetry"); 
        proseRadioButton = new JRadioButton("Prose"); 

        newsLabel = new JLabel("How often do you want to receive our news?"); 
        everyDay = new JCheckBox("Daily"); 
        everyMonth = new JCheckBox("Monthly"); 
        everyWeek = new JCheckBox("Weekly"); 

        saveButton = new JButton("Add book"); 
       
        
        emailLabel.setSize(200, 20); 
        email.setSize(220, 25); 

        bookNameLabel.setSize(200, 20);
        bookName.setSize(220,25);

        authorLabel.setSize(200, 20); 
        author.setSize(220,25);

        bookTypeLabel.setSize(200,20);
        poetryRadioButton.setSize(100, 10); 
        proseRadioButton.setSize(100, 10);  

        newsLabel.setSize(400,20); 
        everyDay.setSize(100,10); 
        everyMonth.setSize(100,10); 
        everyWeek.setSize(100,10); 

        saveButton.setSize(200 ,20); 
        
         
        emailLabel.setLocation(20, 40);
        email.setLocation(20, 70); 

        bookNameLabel.setLocation(20, 100);  
        bookName.setLocation(20, 130); 

        authorLabel.setLocation(20, 160); 
        author.setLocation(20, 190); 

        bookTypeLabel.setLocation(20, 220); 
        poetryRadioButton.setLocation(20, 250); 
        proseRadioButton.setLocation(20, 280);

        newsLabel.setLocation(20,310);  
        everyDay.setLocation(20, 340); 
        everyMonth.setLocation(20, 370); 
        everyWeek.setLocation(20, 400); 
        
        saveButton.setLocation(250, 550);
        

        panel.add(saveButton); 
        panel.add(emailLabel); 
        panel.add(bookNameLabel); 
        panel.add(authorLabel); 
        panel.add(bookTypeLabel); 
        panel.add(newsLabel); 
        panel.add(email); 
        panel.add(bookName); 
        panel.add(author); 
        panel.add(poetryRadioButton); 
        panel.add(proseRadioButton); 
        panel.add(everyDay); 
        panel.add(everyMonth); 
        panel.add(everyWeek); 
        
        
        setContentPane(panel); 

        saveButton.addActionListener(new ButtonActionListener()); 
        poetryRadioButton.addActionListener(new FlagActionListener()); 
        proseRadioButton.addActionListener(new FlagActionListener()); 
    } 
        

    public class ButtonActionListener implements ActionListener { 

        public void actionPerformed(ActionEvent event) { 

        File file = new File("laba6.txt"); 

            try{ 
                if(!file.exists()) { 
                    file.createNewFile(); 
                }

                FileWriter out = new FileWriter(file, true); 

                try{ 
                    out.write("Email: " + LibraryWindow.email.getText() + "\n"); 
                    out.write("Book: " + LibraryWindow.bookName.getText() + "\n"); 
                    out.write("Author: " + LibraryWindow.author.getText() + "\n"); 

                    if(key == 1) { 
                        out.write("Type: Poetry " + "\n"); 

                    } else if(key == -1) { 
                        out.write("Type: Prose " + "\n"); 
                    }

                    out.write("User wants to receive our news: ");

                    if (everyDay.isSelected()) out.write("Daily\n"); 
                    if (everyMonth.isSelected()) out.write("Monthly\n"); 
                    if (everyWeek.isSelected()) out.write("Weekly\n"); 
 
            } finally{ 
                out.close(); 
            } 
            } catch(IOException anotherEvent){ 
                throw new RuntimeException(anotherEvent); 
            } 
        }   
    } 
    
    public class FlagActionListener implements ActionListener { 
        public void actionPerformed(ActionEvent event) { 
        key = 0; 
        if(event.getSource() == poetryRadioButton){ 
           proseRadioButton.setSelected(false); 
            key++; 
        } else if(event.getSource() == proseRadioButton){ 
            poetryRadioButton.setSelected(false); 
            key--; 
        } 
    } 
 } 
}
//  // Пример использования раскрывающихся списков

// import java.awt.event.ActionEvent;
// import java.awt.event.ActionListener;
// import java.util.*;

// import javax.swing.*;

// public class ComboBoxTest extends JFrame {
//     // private static final long serialVersionUID = 1L;
//     // Массив элементов списка
//     public String[] elements = new String[] { "Офис", "Склад", "Гараж", "Производство", "Столовая" };

//     private JComboBox<String> cbFirst;
//     private DefaultComboBoxModel<String> cbModel;

//     public ComboBoxTest() {
//         super("Пример JComboBox");
//         setDefaultCloseOperation(EXIT_ON_CLOSE);

//         // Модель данных списка
//         cbModel = new DefaultComboBoxModel<String>();
//         for (int i = 0; i < elements.length; i++)
//             cbModel.addElement((String) elements[i]);
//         // Данные для 2-го списка
//         Vector<String> data = new Vector<String>();
//         for (int i = 0; i < 10; i++)
//             data.add(String.format("#%d элемент", i));
//         // 1-й раскрывающийся список
//         cbFirst = new JComboBox<String>(cbModel);
//         // Меняем элемент Гараж на Автопарк
//         cbModel.setSelectedItem("Гараж");
//         int idx = cbModel.getIndexOf(cbModel.getSelectedItem());
//         cbModel.removeElementAt(idx);
//         cbModel.insertElementAt("Автопарк", idx);
//         cbModel.setSelectedItem("Автопарк");
//         // Определяем размер списка
//         cbFirst.setPrototypeDisplayValue("Максимальный размер");
//         // 2-й раскрывающийся список
//         JComboBox<String> cbSecond = new JComboBox<String>(data);
//         /*
//          * Определение свойств списка - редактируемый, количество элементов в
//          * раскрывающемся окне
//          */
//         cbSecond.setEditable(true);
//         cbSecond.setMaximumRowCount(5);
//         // Кнопка добавления элемента в модель данных
//         JButton btnAdd = new JButton("Добавить");
//         btnAdd.addActionListener(new ActionListener() {
//             public void actionPerformed(ActionEvent e) {
//                 // Выбираем позицию предпоследнего элемента
//                 int pos = cbModel.getSize() - 1;
//                 cbModel.insertElementAt("~ Добавленная строка ~", pos);
//             }
//         });

//         // Размещение компонентов в интерфейсе и вывод окна
//         JPanel contents = new JPanel();
//         contents.add(cbSecond);
//         contents.add(cbFirst);
//         contents.add(btnAdd);
//         setContentPane(contents);
//         setSize(450, 180);
//         setVisible(true);
//     }

// }

