package pos;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Label;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.DefaultCellEditor;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

public class OrderPanel extends JPanel {
   public JTable table;
   public Label saleslabel2;
   public Label totallabel2;
   public DefaultTableModel dfTable;
   Pos_Burger main;

   class ItemChangeListener implements ItemListener {
      @Override
      public void itemStateChanged(ItemEvent event) {
         if (event.getStateChange() == ItemEvent.SELECTED) {
            String item = (String) event.getItem();
            String selQ = String.valueOf(table.getValueAt(table.getSelectedRow(), table.getSelectedColumn()));

            if (!item.equals(selQ)) {
               main.orderlist.get(table.getSelectedRow()).setTotalPrice(Integer.parseInt(item));
               main.setOrderlist();
            }
         }
      }
   }

   public OrderPanel(Pos_Burger main) {
      this.main = main;

      // �ֹ���ȣ â �г�
      setLayout(null);
      setBounds(20, 100, 360, 480);
      setBackground(Color.black);

      JPanel order_number = new JPanel();
      JLabel order_index = new JLabel("  < �ֹ�ǥ > ");
      // �ֹ���ȣ db �ε����� ���ؼ� ������ ����

      order_number.setBackground(new Color(0x00769E));
      order_number.setBounds(0, 0, 400, 85);

      order_index.setBounds(80, 0, 400, 100);
      order_index.setFont(new Font("���� ���", Font.BOLD, 30));
      order_index.setForeground(Color.white);

      JPanel order_table = new JPanel();
      order_table.setBounds(0, 80, 400, 475);

      String[] columns = new String[] { "�޴�", "����", "�ܰ�", "�ݾ�" };
      Object[][] data = new Object[][] { { "", "", "", "" }, { "", "", "", "" } };

      dfTable = new DefaultTableModel(columns, 0);
      table = new JTable(dfTable);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // ���� ����

      table.setPreferredScrollableViewportSize(new Dimension(400, 250));
      table.setFillsViewportHeight(true);

      order_table.add(new JScrollPane(table));

      TableColumn comm = table.getColumnModel().getColumn(1);

      JComboBox<String> jcCount = new JComboBox<>();
      for (int i = 1; i < 100; i++) {
         jcCount.addItem(String.valueOf(i));
      }
      jcCount.addItemListener(new ItemChangeListener());

      comm.setCellEditor(new DefaultCellEditor(jcCount));

      // �Ǹž�
      Label saleslabel = new Label();

      saleslabel.setText("      �Ǹž�");
      saleslabel.setBackground(new Color(0x00769E));
      saleslabel.setForeground(Color.white);
      saleslabel.setBounds(0, 358, 180, 40);
      saleslabel.setFont(new Font("���� ���", Font.BOLD, 20));

      // ���ξ�
      Label discountlabel = new Label();

      discountlabel.setText("      ���ξ�");
      discountlabel.setBackground(new Color(0x00769E));
      discountlabel.setForeground(Color.white);
      discountlabel.setBounds(0, 398, 180, 40);
      discountlabel.setFont(new Font("���� ���", Font.BOLD, 20));

      // �հ�
      Label totallabel = new Label();
      totallabel.setText("      �հ�");
      totallabel.setBackground(new Color(0x00769E));
      totallabel.setForeground(Color.white);
      totallabel.setBounds(0, 438, 180, 40);
      totallabel.setFont(new Font("���� ���", Font.BOLD, 20));

      // ----------------------------------------------------
      // �Ǹžװ� ���� ��
      saleslabel2 = new Label();

      // saleslabel2.setText(String.valueOf(sum));
      saleslabel2.setBackground(new Color(0xCCFFFF));
      saleslabel2.setBounds(180, 358, 180, 40);
      saleslabel2.setFont(new Font("���� ���", Font.BOLD, 25));

      // ���ξװ� ���� ��
      Label discountlabel2 = new Label();
      discountlabel2.setText("0 ");
      discountlabel2.setBackground(new Color(0xCCFFFF));
      discountlabel2.setBounds(180, 398, 180, 40);
      discountlabel2.setFont(new Font("���� ���", Font.BOLD, 25));

      // �հ谪 ���� ��
      totallabel2 = new Label();
      // totallabel2.setText(String.valueOf(sum));
      totallabel2.setBackground(new Color(0xCCFFFF));
      totallabel2.setBounds(180, 438, 180, 40);
      totallabel2.setFont(new Font("���� ���", Font.BOLD, 25));

      add(saleslabel);
      add(discountlabel);
      add(totallabel);
      add(saleslabel2);
      add(discountlabel2);
      add(totallabel2);
      add(order_index);
      add(order_number);
      add(order_table);

   }
}