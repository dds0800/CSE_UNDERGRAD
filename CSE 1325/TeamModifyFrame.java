/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class will be used to create a GUI in the main class
 * that will allow the user to modify information about a team.
 */

package tournamenttest;

import javax.swing.*;
import java.awt.FlowLayout;
import java.awt.event.*;

public class TeamModifyFrame extends JFrame
{
    private JLabel label1 = new JLabel("Please enter new information about a team. Do NOT leave any fields blank.");
    private JLabel label2 = new JLabel("Team Name: ");
    private JLabel label3 = new JLabel("Team School or Organization: ");
    private JLabel label4 = new JLabel("Team Financial Sponsor: ");
    private JTextField textField1 = new JTextField(30);
    private JTextField textField2 = new JTextField(30);
    private JTextField textField3 = new JTextField(20);
    private JButton doneButton = new JButton("Done");
    private JLabel label5 = new JLabel("Please click done when finished.");
    private Team team;
    
    public TeamModifyFrame(Team team)
    {
        super("Modify Team Information");
        setLayout(new FlowLayout());
        label1.setHorizontalTextPosition(SwingConstants.CENTER);
        label2.setHorizontalTextPosition(SwingConstants.LEFT);
        label3.setHorizontalTextPosition(SwingConstants.LEFT);
        label4.setHorizontalTextPosition(SwingConstants.LEFT);
        label5.setHorizontalAlignment(SwingConstants.CENTER);
        textField1.setHorizontalAlignment(SwingConstants.RIGHT);
        textField2.setHorizontalAlignment(SwingConstants.RIGHT);
        textField3.setHorizontalAlignment(SwingConstants.RIGHT);
        doneButton.setVerticalAlignment(SwingConstants.BOTTOM);
        add(label1);
        add(label5);
        add(label2);
        add(textField1);
        add(label3);
        add(textField2);
        add(label4);
        add(textField3);
        add(doneButton);
        ButtonHandler handler = new ButtonHandler();
        doneButton.addActionListener(handler);
        this.team=team;
    }
    
    /* This method will close the GUI when the user
    clicks the done button*/
    public void close()
    {
        super.dispose();
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    private class ButtonHandler implements ActionListener
    {
        

        @Override
        public void actionPerformed(ActionEvent e) 
        {
            team.setTeamName(textField1.getText());
            team.setGroup(textField2.getText());
            team.setSponsor(textField3.getText());
            close();
        }
        
    }
}