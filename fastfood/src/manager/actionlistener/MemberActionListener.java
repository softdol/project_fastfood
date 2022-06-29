package manager.actionlistener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import manager.member.MemberMain;

public class MemberActionListener implements ActionListener {
	
	private MemberMain memberMain;
	private int idx;
	private char tAction;
	
	public MemberActionListener(MemberMain memberMain, int idx, char tAction) {
		this.memberMain = memberMain;
		this.tAction = tAction;
		this.idx = idx;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		switch (tAction) {
			case 'S':
				memberMain.uptStore();
				break;
			case 'I':
				memberMain.insMember();
				break;
			case 'U':
				memberMain.uptMember(idx);
				break;
			case 'N':
				memberMain.newMember();
				break;
			case 'D':
				memberMain.delMember(idx);
				break;
		}
		
	}
	
}
