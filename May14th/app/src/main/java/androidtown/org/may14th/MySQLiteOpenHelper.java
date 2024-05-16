package androidtown.org.may14th;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MySQLiteOpenHelper extends SQLiteOpenHelper {
    public MySQLiteOpenHelper(Context context, String name,
                              SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, 2); // 버전을 1에서 2로 변경
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 테이블 생성 쿼리 업데이트
        String sql = "CREATE TABLE student (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +  // 자동 증가 설정 추가
                "name TEXT, " +
                "age INTEGER, " +
                "address TEXT);";
        db.execSQL(sql);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "DROP TABLE IF EXISTS student";
        db.execSQL(sql);
        onCreate(db);
    }

}