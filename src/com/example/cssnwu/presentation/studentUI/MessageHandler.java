package com.example.cssnwu.presentation.studentUI;

import java.awt.Component;

import javax.swing.JOptionPane;

import com.example.cssnwu.businesslogicservice.resultenum.ADD_RESULT;
import com.example.cssnwu.businesslogicservice.resultenum.DELETE_RESULT;

public class MessageHandler {
	/**
	 * Title:hangeMessage
	 * Description: ����һЩ��Ϣ
	 * @param r
	 * @param componet
	 * @return  boolean
	 */
	public static boolean handleMessage(DELETE_RESULT r,Component componet)
	{  /**
	    *    ����r����bool
	    */
		switch(r)
		{  case ɾ���ɹ�:
			{   return true;
			
			}
			case �������˴���:
				{   
					JOptionPane.showMessageDialog(componet,"�������˴���");
					return false;
				}
			case Ҫɾ�������ݲ�����:
				{   JOptionPane.showMessageDialog(componet, "Ҫɾ�������ݲ�����");
				    return false;
					
				}
			case ɾ��ʧ��:
				{   JOptionPane.showMessageDialog(componet, "ɾ��ʧ��");
				    return false;
					
				}
			case �γ���ֱѡ�γ̲�����ѡ:
				{   JOptionPane.showMessageDialog(componet, "�γ���ֱѡ�γ̲�����ѡ");
				    return false;
					
				}
			default:{
				return false;
			}
		}
	}
	
	/**
	 * Title:  hangeMessage
	 * Description:������Ϣ
	 * @param r
	 * @param componet
	 * @return
	 */
	public static boolean handleMessage(ADD_RESULT r,Component componet)
	{  switch(r)
		{  case ��ӳɹ�:
			{   return true;
			
			}
			case �������˴���:
				{   
					JOptionPane.showMessageDialog(componet,"�������˴���");
					return false;
				}
			case �����пγ�ʱ���ϳ�ͻ:
				{   JOptionPane.showMessageDialog(componet, "�����пγ�ʱ���ϳ�ͻ");
				    return false;
					
				}
			case �������ſγ��Ͽεص�У����ͬʱ����������:
				{   JOptionPane.showMessageDialog(componet, "�������ſγ��Ͽεص�У����ͬʱ����������");
				    return false;
					
				}
			case �Ѿ�ѡ���˱��γ̲����ٴ�ѡ��:
				{   JOptionPane.showMessageDialog(componet, "�Ѿ�ѡ���˱��γ̲����ٴ�ѡ��");
				    return false;
					
				}
			case ����ʧ��:
			{   JOptionPane.showMessageDialog(componet, "����ʧ��");
			    return false;
				
			}
			default:{
				return false;
			}
		}
	
		
	}


}
