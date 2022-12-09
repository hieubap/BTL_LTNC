package cinema.booking.db;

import java.util.List;

public interface Query {
  List<String> search(String text);
  void create(List<String> data);
  int update(List<String> data, int id);

}
