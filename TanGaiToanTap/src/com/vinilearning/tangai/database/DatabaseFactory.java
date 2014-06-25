package com.vinilearning.tangai.database;

import java.util.ArrayList;

import android.content.Context;
import android.database.Cursor;

import com.vinilearning.tangai.model.MCategory;
import com.vinilearning.tangai.model.MDanhSach;
import com.vinilearning.tangai.model.MFavorites;

public class DatabaseFactory {
	public static MyDataBase db;

	public static ArrayList<MCategory> categorys;

	public static ArrayList<MDanhSach> danhsach;

	public static ArrayList<MFavorites> favorites;

	static {
		categorys = null;
		danhsach = null;
	}

	/**
	 * Method used to get all danh sach.
	 * 
	 * @param context
	 * @return
	 */
	public static ArrayList<MDanhSach> getAllDanhSach(Context context) {
		danhsach = null;
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllContentFromDb();
		if (localCursor != null) {
			danhsach = new ArrayList<MDanhSach>();
		}

		if (localCursor.moveToFirst()) {
			do {
				MDanhSach mContent = new MDanhSach(
						localCursor.getInt(localCursor
								.getColumnIndex(MyDataBase.CONTENT_ID)),
						localCursor.getInt(localCursor
								.getColumnIndex(MyDataBase.CONTENT_ITEM_ID)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CONTENT_TEXT)),
						localCursor.getInt(localCursor
								.getColumnIndex(MyDataBase.CONTENT_PARENTID)));
				danhsach.add(mContent);
			} while (localCursor.moveToNext());
		}
		localCursor.close();
		db.close();

		return danhsach;
	}

	/**
	 * Method used to get all chapter.
	 * 
	 * @param context
	 * @return
	 */
	public static ArrayList<MCategory> getAllCategory(Context context) {
		categorys = null;
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllCategoryFromDb();
		if (localCursor != null) {
			categorys = new ArrayList<MCategory>();
		}

		if (localCursor.moveToFirst()) {
			do {
				MCategory mChapter = new MCategory(
						localCursor.getInt(localCursor
								.getColumnIndex(MyDataBase.CATEGORY_ID)),
						localCursor.getString(localCursor
								.getColumnIndex(MyDataBase.CATEGORY_CONTENT)));
				categorys.add(mChapter);
			} while (localCursor.moveToNext());
		}
		localCursor.close();
		db.close();
		return categorys;
	}

	public static ArrayList<MFavorites> getAllFavorites(Context context) {
		favorites = null;
		db = new MyDataBase(context);
		Cursor localCursor = db.getAllFavoritesFromDb();
		if (localCursor != null) {
			favorites = new ArrayList<MFavorites>();
		}

		if (localCursor.moveToFirst()) {
			do {
				MFavorites mFavorites = new MFavorites(
						localCursor.getInt(localCursor
								.getColumnIndex(MyDataBase.FAVORITES_ID)),
						localCursor.getInt(localCursor
								.getColumnIndex(MyDataBase.FAVORITES_ID_DANHSACH)));
				favorites.add(mFavorites);
			} while (localCursor.moveToNext());
		}
		localCursor.close();
		db.close();
		return favorites;
	}
}
