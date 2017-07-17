/*
 * Author: Daniel Singh
 * UTA ID:1000930800
 * CSE 1325 Dr. Tiernan
 * Description: This class will be used to create a GUI in the main class
 * that will allow the user to modify information about a team member.
 */

package tournamenttest;

import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class TeamMemberModifyFrame extends JFrame
{
    private JLabel label1 = new JLabel("Please select an item. Click OK when done editing.");
    /*private JLabel label2 = new JLabel("First Name: ");
    private JLabel label3 = new JLabel("Last Name: ");
    private JLabel label4 = new JLabel("Email Address: ");
    private JLabel label5 = new JLabel("Number of Saftey Violations (Please input a positive double digit number): ");
    private JLabel label6 = new JLabel("Grade (Please select a grade from 7 to 12 and input two digits ex: 07): ");
    private JLabel label7 = new JLabel("Age (Please select an age from 10 to 20): ");
    private JLabel label8 = new JLabel("Click Done when finished");
    private JTextField textField1 = new JTextField(20);
    private JTextField textField2 = new JTextField(20);
    private JTextField textField3 = new JTextField(20);
    private JTextField textField4 = new JTextField(2);
    private JTextField textField5 = new JTextField(2);
    private JTextField textField6 = new JTextField(2);
    private JComboBox teamMembers;*/
    private JRadioButton pMentor = new JRadioButton("Peer Mentor",true);
    private JRadioButton experienced = new JRadioButton("Experienced",false);
    private JRadioButton novice = new JRadioButton("Novice",false);
    private JButton OK = new JButton("OK");
    private TeamMember teamMember;
    private Team team;
    private JList numbers;
    private JList teamMembers;
    private ButtonGroup radioGroup;
 
    public TeamMemberModifyFrame(ArrayList<Team> teams)
    {
        super("Please select a team number");
        setLayout(new FlowLayout());
        Team[] teamNumbers = new Team[teams.size()];
        int i=0;
        for(Team team:teams)
        {
            teamNumbers[i]=team;
            i+=1;
        }
        numbers = new JList(teamNumbers);
        numbers.setVisibleRowCount(4);
        label1.setHorizontalTextPosition(SwingConstants.LEFT);
        OK.setVerticalAlignment(SwingConstants.BOTTOM);
        OK.setHorizontalAlignment(SwingConstants.RIGHT);
        add(label1);
        add(new JScrollPane(numbers));
        add(OK);
        OK.addActionListener(new ButtonHandler());
        numbers.addListSelectionListener(new ListHandler());
    }
    
    public TeamMemberModifyFrame(Team team)
    {
        super("Please select a team member");
        setLayout(new FlowLayout());
        TeamMember[] members = new TeamMember[team.getTeamMembers().size()];
        int i=0;
        for(TeamMember member :team.getTeamMembers())
        {
            members[i]=member;
            i+=1;
        }
        teamMembers = new JList(members);
        teamMembers.setVisibleRowCount(3);
        add(new JScrollPane(teamMembers));
        teamMembers.addListSelectionListener(new ListHandler2());
    }
    
    public TeamMemberModifyFrame(TeamMember member)
    {
        super("Please select experience level");
        setLayout(new FlowLayout());
        add(label1);
        add(pMentor);
        add(experienced);
        add(novice);
        add(OK);
        OK.addActionListener(new ButtonHandler());
        radioGroup = new ButtonGroup();
        radioGroup.add(pMentor);
        radioGroup.add(experienced);
        radioGroup.add(novice);
        pMentor.addItemListener(new RadioButtonHandler(member));
        experienced.addItemListener(new RadioButtonHandler(member));
        novice.addItemListener(new RadioButtonHandler(member));
        
    }
    
    public void close()
    {
        super.dispose();
    }

    public TeamMember getTeamMember() {
        return teamMember;
    }

    public void setTeamMember(TeamMember teamMember) {
        this.teamMember = teamMember;
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
            close();
        }
        
    }
    
    private class ListHandler implements ListSelectionListener
    {

        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            Team team=(Team) numbers.getSelectedValue();
            setTeam(team);
            close();
            TeamMemberModifyFrame frame = new TeamMemberModifyFrame(team);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(630,300);
            frame.setVisible(true);
        }
        
    }
    
    private class ListHandler2 implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e) 
        {
            TeamMember member=(TeamMember) teamMembers.getSelectedValue();
            setTeamMember(member);
            close();
            TeamMemberModifyFrame frame = new TeamMemberModifyFrame(member);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setSize(630,300);
            frame.setVisible(true);
        }
    }
    
    private class RadioButtonHandler implements ItemListener
    {
        private TeamMember person;
        
        public RadioButtonHandler(TeamMember person)
        {
            this.person=person;
        }

        @Override
        public void itemStateChanged(ItemEvent e) 
        {
               if(pMentor.isSelected())
                   person.setExperience(TournamentEnumeration.teamExperience.PEER_MENTOR);
               else if(experienced.isSelected())
                   person.setExperience(TournamentEnumeration.teamExperience.EXPERIENCED);
               else if(novice.isSelected())
                   person.setExperience(TournamentEnumeration.teamExperience.NOVICE);
        }
    }
}