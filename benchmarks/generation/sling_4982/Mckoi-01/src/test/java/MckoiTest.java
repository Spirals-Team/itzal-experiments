import java.sql.SQLException;
import java.util.Calendar;
import org.junit.Test;

import com.mckoi.database.jdbc.MConnection;
import com.mckoi.database.jdbc.MStatement;
import com.mckoi.database.jdbcserver.JDBCDatabaseInterface;


public class MckoiTest {
	@Test
	public void test() throws SQLException {
		Calendar timer = Calendar.getInstance();
		MStatement m = new MStatement(new MConnection("", new JDBCDatabaseInterface(null, ""), 0, 0));
		m.executeQuery("nop");
		System.out.println(Calendar.getInstance().getTimeInMillis()-timer.getTimeInMillis());
	}
}
