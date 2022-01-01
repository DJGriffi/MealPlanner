import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JSeparator;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MealPlannerGUI
{
    private JFrame frame;
    private ArrayList<JLabel> daysOfWeek;
    private MealPlanner mealPlanner;
    private int numBeef, numChicken, numPork, numMeatless;
    private JSpinner beefSpinner, chickenSpinner, porkSpinner, meatlessSpinner;
    private SpinnerNumberModel beefSpinMod, chickenSpinMod, porkSpinMod, meatlessSpinMod;
    public MealPlannerGUI()
    {
        numBeef = 0;
        numChicken = 0;
        numPork = 0;
        numMeatless = 0;
        mealPlanner = new MealPlanner();
        daysOfWeek = new ArrayList<>();
        beefSpinMod = new SpinnerNumberModel(0, 0, mealPlanner.getBeefMealSize(), 1);
        beefSpinner = new JSpinner(beefSpinMod);
        chickenSpinMod = new SpinnerNumberModel(0, 0, mealPlanner.getChickenMealSize(), 1);
        chickenSpinner = new JSpinner(chickenSpinMod);
        porkSpinMod = new SpinnerNumberModel(0, 0, mealPlanner.getPorkMealSize(), 1);
        porkSpinner = new JSpinner(porkSpinMod);
        meatlessSpinMod = new SpinnerNumberModel(0, 0, mealPlanner.getMeatlessMealSize(), 1);
        meatlessSpinner = new JSpinner(meatlessSpinMod);
        makeFrame();
        daysLabels();
    }

    private void makeFrame()
    {
        frame = new JFrame("Meal Planner");
        frame.setLayout(null);
        frame.setSize(1000, 925);
        
        JLabel title = new JLabel("Meal Planner", SwingConstants.CENTER);
        title.setBounds(0, 0, 1000, 100);
        frame.add(title);
        JSeparator sep0 = new JSeparator();
        sep0.setBounds(0, 100, 1000, 1);
        frame.add(sep0);

        JLabel monday = new JLabel("Monday");
        monday.setBounds(50, 100, 250, 110);
        frame.add(monday);

        JSeparator sep1 = new JSeparator();
        sep1.setBounds(0, 210, 800, 1);
        frame.add(sep1);

        JLabel tuesday = new JLabel("Tuesday");
        tuesday.setBounds(50, 210, 250, 110);
        frame.add(tuesday);

        JSeparator sep2 = new JSeparator();
        sep2.setBounds(0, 320, 800, 1);
        frame.add(sep2);

        JLabel wednesday = new JLabel("Wednesday");
        wednesday.setBounds(50, 320, 250, 110);
        frame.add(wednesday);

        JSeparator sep3 = new JSeparator();
        sep3.setBounds(0, 430, 800, 1);
        frame.add(sep3);

        JLabel thursday = new JLabel("Thursday");
        thursday.setBounds(50, 430, 250, 110);
        frame.add(thursday);

        JSeparator sep4 = new JSeparator();
        sep4.setBounds(0, 540, 800, 1);
        frame.add(sep4);

        JLabel friday = new JLabel("Friday");
        friday.setBounds(50, 540, 250, 110);
        frame.add(friday);

        JSeparator sep5 = new JSeparator();
        sep5.setBounds(0, 650, 800, 1);
        frame.add(sep5);

        JLabel saturday = new JLabel("Saturday");
        saturday.setBounds(50, 650, 250, 110);
        frame.add(saturday);

        JSeparator sep6 = new JSeparator();
        sep6.setBounds(0, 760, 800, 1);
        frame.add(sep6);

        JLabel sunday = new JLabel("Sunday");
        sunday.setBounds(50, 760, 250, 110);
        frame.add(sunday);

        JSeparator sep7 = new JSeparator(1);
        sep7.setBounds(200, 100, 1, 900);
        frame.add(sep7);

        JSeparator sep8 = new JSeparator(1);
        sep8.setBounds(800, 100, 1, 900);
        frame.add(sep8);

        JButton createButton = new JButton("Create");
        createButton.setBounds(850, 725, 100, 50);
        createButton.addActionListener(e -> generatePlan());
        frame.add(createButton);

        JButton resetButton = new JButton("Reset");
        resetButton.setBounds(850, 800, 100, 50);
        resetButton.addActionListener(e -> reset());
        frame.add(resetButton);


        JLabel numOfBeef = new JLabel("How many beef meals?");
        numOfBeef.setBounds(800, 100, 200, 100);
        numOfBeef.setHorizontalAlignment(JLabel.CENTER);
        frame.add(numOfBeef);

        beefSpinner.setBounds(875, 175, 50, 30);
        beefSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                Object o = beefSpinner.getValue();
                Number n = (Number) o;
                numBeef = n.intValue();
            }
        });
        frame.add(beefSpinner);

        JLabel numOfChicken = new JLabel("How many chicken meals?");
        numOfChicken.setBounds(800, 200, 200, 100);
        numOfChicken.setHorizontalAlignment(JLabel.CENTER);
        frame.add(numOfChicken);

        chickenSpinner.setBounds(875, 275, 50, 30);
        chickenSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                Object o = chickenSpinner.getValue();
                Number n = (Number) o;
                numChicken = n.intValue();
            }
        });
        frame.add(chickenSpinner);

        JLabel numOfPork = new JLabel("How many pork meals?");
        numOfPork.setBounds(800, 300, 200, 100);
        numOfPork.setHorizontalAlignment(JLabel.CENTER);
        frame.add(numOfPork);

        porkSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                Object o = porkSpinner.getValue();
                Number n = (Number) o;
                numPork = n.intValue();
            }
        });
        porkSpinner.setBounds(875, 375, 50, 30);
        frame.add(porkSpinner);

        JLabel numOfMeatless = new JLabel("How many meatless meals?");
        numOfMeatless.setBounds(800, 400, 200, 100);
        numOfMeatless.setHorizontalAlignment(JLabel.CENTER);
        frame.add(numOfMeatless);

        meatlessSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e){
                Object o = meatlessSpinner.getValue();
                Number n = (Number) o;
                numMeatless = n.intValue();
            }
        });
        meatlessSpinner.setBounds(875, 475, 50, 30);
        frame.add(meatlessSpinner);


        makeMenuBar();

        createRecipeButtons();

        frame.addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e)
            {
                System.exit(0);
            }
        });
        
        frame.setVisible(true);
    }

    private void makeMenuBar()
    {
        JMenuBar menuBar = new JMenuBar();
        frame.setJMenuBar(menuBar);

        JMenu fileMenu = new JMenu("File");
        menuBar.add(fileMenu);

        JMenuItem exitItem = new JMenuItem("Exit");
        exitItem.addActionListener(e -> exit());
        fileMenu.add(exitItem);
    }

    private void createRecipeButtons()
    {
        int y = 130;
        for(int i = 0; i < 7; i++){
            JButton button = new JButton("Get recipe");
            button.setBounds(650, y, 125, 50);
            frame.add(button);
            y += 110;
        }
    }

    private void exit()
    {
        System.exit(0);
    }


    private void generatePlan()
    {
        if(numBeef + numChicken + numPork + numMeatless == 7){
            ArrayList<String> meals = mealPlanner.getMeal(numBeef, numChicken, numPork, numMeatless);
            for(int i = 0; i < 7; i++){
                daysOfWeek.get(i).setText(meals.get(i));
            }
        }
        else{
            JOptionPane.showMessageDialog(frame, "Total number of meals must equal seven.",
                                          "Error", JOptionPane.WARNING_MESSAGE);
        }
    }

    private void daysLabels()
    {
        Collections.addAll(daysOfWeek, new JLabel(), new JLabel(), new JLabel(), new JLabel(),
        new JLabel(), new JLabel(), new JLabel() );

        int y = 100;

        for(int i = 0; i < daysOfWeek.size(); i++){
            daysOfWeek.get(i).setBounds(250, y, 550, 110);
            frame.add(daysOfWeek.get(i));
            y += 110;
        }
    }

    private void reset()
    {
        beefSpinner.setValue(0);
        chickenSpinner.setValue(0);
        porkSpinner.setValue(0);
        meatlessSpinner.setValue(0);
        for(int i = 0; i < daysOfWeek.size(); i++){
            daysOfWeek.get(i).setText(null);
        }
        mealPlanner.reset();
    }

    public static void main(String[] args) {
        new MealPlannerGUI();
    }
}