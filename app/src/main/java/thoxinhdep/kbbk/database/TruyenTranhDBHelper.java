package thoxinhdep.kbbk.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import thoxinhdep.kbbk.entity.TruyenTranh;

/**
 * Created by doanLV4 on 10/5/2017.
 */

public class TruyenTranhDBHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "TRUYEN_TRANH_DATABASE";
    private static final int DATABASE_VERSION = 5;
    private static final String TABLE_NAME = TruyenField.TABLE_NAME;
    private static final String ID = TruyenField.ID;
    private static final String TRUYEN_ID = TruyenField.TRUYEN_ID;
    private static final String TRUYEN_TITLE = TruyenField.TRUYEN_TITLE;
    private static final String LIST_CLICKED = TruyenField.LIST_CLICKED;
    private static final String IMAGE_READ = TruyenField.IMAGE_READ;

    // Tag table create statement
    private static final String CREATE_TABLE_TRUYENTRANH = "CREATE TABLE IF NOT EXISTS "
            + TABLE_NAME + "("
            + ID
            + " INTEGER PRIMARY KEY,"
            + TRUYEN_ID
            + " TEXT,"
            + TRUYEN_TITLE
            + " TEXT,"
            + LIST_CLICKED
            + " TEXT,"
            + IMAGE_READ
            + " TEXT"
            + ")";

    private static final String CREATE_TABLE_TRUYENTRANH_1 = "CREATE TABLE IF NOT EXISTS "
            + "TRUYENTRANH1" + "("
            + ID
            + " INTEGER PRIMARY KEY,"
            + TRUYEN_ID
            + " TEXT UNIQUE,"
            + TRUYEN_TITLE
            + " TEXT,"
            + LIST_CLICKED
            + " TEXT,"
            + IMAGE_READ
            + " TEXT"
            + ")";

    private static final String CREATE_TABLE_TRUYENTRANH_2 = "CREATE TABLE IF NOT EXISTS "
            + "TRUYENTRANH2" + "("
            + ID
            + " INTEGER PRIMARY KEY,"
            + TRUYEN_ID
            + " TEXT,"
            + TRUYEN_TITLE
            + " TEXT,"
            + LIST_CLICKED
            + " TEXT,"
            + IMAGE_READ
            + " TEXT"
            + ")";

    private static final String TAG = TruyenTranhDBHelper.class.getSimpleName();

    public TruyenTranhDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_TRUYENTRANH);
//        db.execSQL(CREATE_TABLE_TRUYENTRANH_1);
//        db.execSQL(CREATE_TABLE_TRUYENTRANH_2);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if (newVersion > oldVersion) {
            switch (oldVersion) {
                case 2:
                    db.delete(TABLE_NAME, null, null);
                    String insert = "INSERT INTO TRUYENTRANH1 SELECT * FROM " + TABLE_NAME;
                    String drop = "DROP TABLE " + TABLE_NAME;
                    String changeName = "ALTER TABLE TRUYENTRANH1 RENAME TO " + TABLE_NAME;
                    db.execSQL(insert);
                    db.execSQL(drop);
                    db.execSQL(changeName);
                    break;
                case 3:
                    db.delete(TABLE_NAME, null, null);
                    String insert3 = "INSERT INTO TRUYENTRANH2 SELECT * FROM " + TABLE_NAME;
                    String drop3 = "DROP TABLE " + TABLE_NAME;
                    String changeName3 = "ALTER TABLE TRUYENTRANH2 RENAME TO " + TABLE_NAME;
                    db.execSQL(insert3);
                    db.execSQL(drop3);
                    db.execSQL(changeName3);
                    break;
                case 4:
                    db.delete(TABLE_NAME, null, null);
                    break;
                default:
                    break;
            }
            Log.d(TAG, "onUpgrade: delete success");
            onCreate(db);
        }
    }

    public void insertTruyenTranh(TruyenEntity entity) {

        if (!allTruyenId().contains(entity.getTruyenId())) {
            SQLiteDatabase db = this.getWritableDatabase();
            Gson gson = new Gson();
            String jsonListClick = gson.toJson(entity.getListCLicked());
            String jsonImage = gson.toJson(entity.getImageRead());

            ContentValues values = new ContentValues();
            values.put(TruyenField.TRUYEN_ID, entity.getTruyenId());
            values.put(TruyenField.TRUYEN_TITLE, entity.getTruyenTitle());
            if (jsonListClick != null && jsonImage != null) {
                values.put(TruyenField.LIST_CLICKED, jsonListClick);
                values.put(TruyenField.IMAGE_READ, jsonImage);
            } else {
                values.put(TruyenField.LIST_CLICKED, "");
                values.put(TruyenField.IMAGE_READ, "");
            }

            db.insert(TABLE_NAME, null, values);
        }
    }

    public void updateDataWithColumn(String truyenId, String itemClick){
        if (!getListClick(truyenId).contains(itemClick)) {
            Gson gson = new Gson();
            ArrayList<String> list = getListClick(truyenId);
            String jsonListClick;
            if (list.isEmpty()) {
                list = new ArrayList<>();
            }
            list.add(itemClick);
            jsonListClick = gson.toJson(list);

            String update = "UPDATE " + TABLE_NAME + " SET " + LIST_CLICKED + " = '"+jsonListClick+"'"+ " WHERE " + TRUYEN_ID + " = " + truyenId;
            Log.d(TAG, "updateDataWithColumn: update = " + update);
            SQLiteDatabase db = this.getReadableDatabase();
            db.execSQL(update);
            db.close();
        }
    }

    private ArrayList<String> getListClick(String truyenId) {
        String query = "SELECT  * FROM " + TABLE_NAME +" WHERE " + TRUYEN_ID + " = " + truyenId;
        SQLiteDatabase db = this.getReadableDatabase();
        ArrayList<String> listClick = new ArrayList<>();
        Cursor c = db.rawQuery(query, null);
        if (c != null) {
            c.moveToFirst();
            Gson gson = new Gson();
            Type type = new TypeToken<ArrayList<String>>() {}.getType();
            listClick = gson.fromJson(c.getString(c.getColumnIndex(LIST_CLICKED)), type);
        }
        return listClick;
    }

    public int getTableCount() {
        String countQuery = "SELECT  * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();

        // return count
        return count;

    }

    private ArrayList<String> allTruyenId() {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME;
        Cursor c = db.rawQuery(selectQuery, null);
        ArrayList<String> listTruyenId = new ArrayList<>();
        if (c.moveToFirst()) {
            do {
                String truyenId = c.getString(c.getColumnIndex(TRUYEN_ID));
                listTruyenId.add(truyenId);
            } while (c.moveToNext());
        }
        return listTruyenId;
    }

    public TruyenEntity getTruyenTranhByTruyenId(String truyenID) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE "
                + TRUYEN_ID + " = " + truyenID;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }
        TruyenEntity entity = new TruyenEntity();
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> listClick;
        ArrayList<String> imageRead;

        if (c != null) {
            listClick = gson.fromJson(c.getString(c.getColumnIndex(LIST_CLICKED)), type);
//            listClick = gson.fromJson(c.getString(c.getColumnIndex(LIST_CLICKED)), type);
            imageRead = gson.fromJson(c.getString(c.getColumnIndex(IMAGE_READ)), type);
            entity.setTruyenId(c.getString(c.getColumnIndex(TRUYEN_ID)));
            entity.setTruyenTitle(c.getString(c.getColumnIndex(TRUYEN_TITLE)));
            entity.setListCLicked(listClick);
            entity.setImageRead(imageRead);
            c.close();
        }
        return entity;
    }

    public TruyenEntity getTruyenTranh(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        String selectQuery = "SELECT  * FROM " + TABLE_NAME + " WHERE "
                + ID + " = " + id;
        Cursor c = db.rawQuery(selectQuery, null);
        if (c != null) {
            c.moveToFirst();
        }
        TruyenEntity entity = new TruyenEntity();
        Gson gson = new Gson();
        Type type = new TypeToken<ArrayList<String>>() {}.getType();
        ArrayList<String> listClick;
        ArrayList<String> imageRead;

        if (c != null) {
            listClick = gson.fromJson(c.getString(c.getColumnIndex(LIST_CLICKED)), type);
//            listClick = gson.fromJson(c.getString(c.getColumnIndex(LIST_CLICKED)), type);
            imageRead = gson.fromJson(c.getString(c.getColumnIndex(IMAGE_READ)), type);
            entity.setTruyenId(c.getString(c.getColumnIndex(TRUYEN_ID)));
            entity.setTruyenTitle(c.getString(c.getColumnIndex(TRUYEN_TITLE)));
            entity.setListCLicked(listClick);
            entity.setImageRead(imageRead);
            c.close();
        }
        return entity;
    }
}
