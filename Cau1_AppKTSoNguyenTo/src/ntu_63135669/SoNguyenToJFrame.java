package ntu_63135669;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
public class SoNguyenToJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtSoNguyen;
	/**
	 * Create the frame.
	 */
	public SoNguyenToJFrame() {
		setTitle("ỨNG DỤNG KIỂM TRA SỐ NGUYÊN TỐ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nhập một số nguyên tố:");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel.setBounds(68, 72, 245, 43);
		contentPane.add(lblNewLabel);
		
		txtSoNguyen = new JTextField();
		txtSoNguyen.setFont(new Font("Arial", Font.PLAIN, 15));
		txtSoNguyen.setBounds(68, 120, 352, 43);
		contentPane.add(txtSoNguyen);
		txtSoNguyen.setColumns(10);
		
		JButton btnKiemTra = new JButton("Kiểm tra");
		btnKiemTra.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuLyKiemTra();
			}
		});
		btnKiemTra.setFont(new Font("Arial", Font.PLAIN, 15));
		btnKiemTra.setBounds(124, 184, 108, 41);
		contentPane.add(btnKiemTra);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				XuLyKetThuc();
			}
		});
		btnCancel.setFont(new Font("Arial", Font.PLAIN, 15));
		btnCancel.setBounds(274, 184, 108, 41);
		contentPane.add(btnCancel);
	}
	void XuLyKiemTra() {
	    // Lấy về số nguyên
	    String strSoNguyen = txtSoNguyen.getText();
	    
	    try {
	        // Chuyển chuỗi thành số nguyên
	        int SoNguyen = Integer.parseInt(strSoNguyen);
	        
	        // Kiểm tra xem số vừa nhập có phải là số nguyên tố hay không
	        boolean isPrime = true;
	        if (SoNguyen <= 1) {
	            isPrime = false;
	        } else {
	            for (int i = 2; i <= Math.sqrt(SoNguyen); i++) {
	                if (SoNguyen % i == 0) {
	                    isPrime = false;
	                    break;
	                }
	            }
	        }
	        
	        // Hiển thị kết quả
	        if (isPrime) {
	            JOptionPane.showMessageDialog(null, "Số vừa nhập là số nguyên tố", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
	        } else {
	            JOptionPane.showMessageDialog(null, "Số vừa nhập không phải là số nguyên tố", "Kết quả", JOptionPane.INFORMATION_MESSAGE);
	        }
	        
	        txtSoNguyen.setText(""); // Xóa nội dung ô văn bản để người dùng nhập số mới
	    } catch (NumberFormatException ex) {
	        JOptionPane.showMessageDialog(null, "Nhập sai dữ liệu");
	        txtSoNguyen.setText("");
	    }
	}
	void XuLyKetThuc() {
		// Đóng cửa sổ hiện tại (chương trình sẽ kết thúc)
	    dispose();
	}
}
