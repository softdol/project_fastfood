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

      // 주문번호 창 패널
      setLayout(null);
      setBounds(20, 100, 360, 480);
      setBackground(Color.black);

      JPanel order_number = new JPanel();
      JLabel order_index = new JLabel("  < 주문표 > ");
      // 주문번호 db 인덱스를 통해서 가져올 예정

      order_number.setBackground(new Color(0x00769E));
      order_number.setBounds(0, 0, 400, 85);

      order_index.setBounds(80, 0, 400, 100);
      order_index.setFont(new Font("맑은 고딕", Font.BOLD, 30));
      order_index.setForeground(Color.white);

      JPanel order_table = new JPanel();
      order_table.setBounds(0, 80, 400, 475);

      String[] columns = new String[] { "메뉴", "수량", "단가", "금액" };
      Object[][] data = new Object[][] { { "", "", "", "" }, { "", "", "", "" } };

      dfTable = new DefaultTableModel(columns, 0);
      table = new JTable(dfTable);
      table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION); // 단일 선택

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

      // 판매액
      Label saleslabel = new Label();

      saleslabel.setText("      판매액");
      saleslabel.setBackground(new Color(0x00769E));
      saleslabel.setForeground(Color.white);
      saleslabel.setBounds(0, 358, 180, 40);
      saleslabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

      // 할인액
      Label discountlabel = new Label();

      discountlabel.setText("      할인액");
      discountlabel.setBackground(new Color(0x00769E));
      discountlabel.setForeground(Color.white);
      discountlabel.setBounds(0, 398, 180, 40);
      discountlabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

      // 합계
      Label totallabel = new Label();
      totallabel.setText("      합계");
      totallabel.setBackground(new Color(0x00769E));
      totallabel.setForeground(Color.white);
      totallabel.setBounds(0, 438, 180, 40);
      totallabel.setFont(new Font("맑은 고딕", Font.BOLD, 20));

      // ----------------------------------------------------
      // 판매액값 들어가는 라벨
      saleslabel2 = new Label();

      // saleslabel2.setText(String.valueOf(sum));
      saleslabel2.setBackground(new Color(0xCCFFFF));
      saleslabel2.setBounds(180, 358, 180, 40);
      saleslabel2.setFont(new Font("맑은 고딕", Font.BOLD, 25));

      // 할인액값 들어가는 라벨
      Label discountlabel2 = new Label();
      discountlabel2.setText("0 ");
      discountlabel2.setBackground(new Color(0xCCFFFF));
      discountlabel2.setBounds(180, 398, 180, 40);
      discountlabel2.setFont(new Font("맑은 고딕", Font.BOLD, 25));

      // 합계값 들어가는 라벨
      totallabel2 = new Label();
      // totallabel2.setText(String.valueOf(sum));
      totallabel2.setBackground(new Color(0xCCFFFF));
      totallabel2.setBounds(180, 438, 180, 40);
      totallabel2.setFont(new Font("맑은 고딕", Font.BOLD, 25));

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