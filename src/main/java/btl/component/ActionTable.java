package btl.component;

import java.sql.SQLException;

/** mục đích: thay cho kiểu truyền generic giữa MyTale và MyModal
 * xảy ra khi đưa vào generic 1 kiểu có generic đi theo
 *
 * TH: X không cần generic là con của Y
 * class Z
 * class X<A extend Z>
 * class Y<C extend Z, D extend X<C>>
 *
 * TH: X và Y cần generic là con của nhau
 * class Z
 * class X<A extend Z, B extend Y<A, |cần đưa vào kiểu của X| >>
 * class Y<C extend Z, D extend X<C, |cần đưa vào kiểu của Y| >>
 *
 */
public interface ActionTable {
    // xử lý show popup tại mỗi dòng khi ấn update
    int clickRowBtn(int row);

    // reload sau khi submit
    void loadData() throws SQLException;

    // khi ấn nút tìm kiếm
    void search(String text) throws SQLException;
}
