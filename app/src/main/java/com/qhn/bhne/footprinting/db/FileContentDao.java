package com.qhn.bhne.footprinting.db;

import java.util.List;
import android.database.Cursor;
import android.database.sqlite.SQLiteStatement;

import org.greenrobot.greendao.AbstractDao;
import org.greenrobot.greendao.Property;
import org.greenrobot.greendao.internal.DaoConfig;
import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseStatement;
import org.greenrobot.greendao.query.Query;
import org.greenrobot.greendao.query.QueryBuilder;

import com.qhn.bhne.footprinting.mvp.entries.FileContent;

// THIS CODE IS GENERATED BY greenDAO, DO NOT EDIT.
/** 
 * DAO for table "FILE_CONTENT".
*/
public class FileContentDao extends AbstractDao<FileContent, Long> {

    public static final String TABLENAME = "FILE_CONTENT";

    /**
     * Properties of entity FileContent.<br/>
     * Can be used for QueryBuilder and for referencing column names.
     */
    public static class Properties {
        public final static Property FileID = new Property(0, Long.class, "fileID", true, "_id");
        public final static Property ParentID = new Property(1, Long.class, "parentID", false, "PARENT_ID");
        public final static Property ChildId = new Property(2, Long.class, "childId", false, "CHILD_ID");
        public final static Property FileName = new Property(3, String.class, "fileName", false, "FILE_NAME");
        public final static Property UserName = new Property(4, String.class, "userName", false, "USER_NAME");
        public final static Property Date = new Property(5, String.class, "date", false, "DATE");
        public final static Property FileMax = new Property(6, int.class, "FileMax", false, "FILE_MAX");
    }

    private DaoSession daoSession;

    private Query<FileContent> construction_FileContentListQuery;

    public FileContentDao(DaoConfig config) {
        super(config);
    }
    
    public FileContentDao(DaoConfig config, DaoSession daoSession) {
        super(config, daoSession);
        this.daoSession = daoSession;
    }

    /** Creates the underlying database table. */
    public static void createTable(Database db, boolean ifNotExists) {
        String constraint = ifNotExists? "IF NOT EXISTS ": "";
        db.execSQL("CREATE TABLE " + constraint + "\"FILE_CONTENT\" (" + //
                "\"_id\" INTEGER PRIMARY KEY AUTOINCREMENT ," + // 0: fileID
                "\"PARENT_ID\" INTEGER NOT NULL ," + // 1: parentID
                "\"CHILD_ID\" INTEGER UNIQUE ," + // 2: childId
                "\"FILE_NAME\" TEXT NOT NULL ," + // 3: fileName
                "\"USER_NAME\" TEXT NOT NULL ," + // 4: userName
                "\"DATE\" TEXT NOT NULL ," + // 5: date
                "\"FILE_MAX\" INTEGER NOT NULL );"); // 6: FileMax
        // Add Indexes
        db.execSQL("CREATE UNIQUE INDEX " + constraint + "IDX_FILE_CONTENT_FILE_NAME ON FILE_CONTENT" +
                " (\"FILE_NAME\" ASC);");
    }

    /** Drops the underlying database table. */
    public static void dropTable(Database db, boolean ifExists) {
        String sql = "DROP TABLE " + (ifExists ? "IF EXISTS " : "") + "\"FILE_CONTENT\"";
        db.execSQL(sql);
    }

    @Override
    protected final void bindValues(DatabaseStatement stmt, FileContent entity) {
        stmt.clearBindings();
 
        Long fileID = entity.getFileID();
        if (fileID != null) {
            stmt.bindLong(1, fileID);
        }
        stmt.bindLong(2, entity.getParentID());
 
        Long childId = entity.getChildId();
        if (childId != null) {
            stmt.bindLong(3, childId);
        }
        stmt.bindString(4, entity.getFileName());
        stmt.bindString(5, entity.getUserName());
        stmt.bindString(6, entity.getDate());
        stmt.bindLong(7, entity.getFileMax());
    }

    @Override
    protected final void bindValues(SQLiteStatement stmt, FileContent entity) {
        stmt.clearBindings();
 
        Long fileID = entity.getFileID();
        if (fileID != null) {
            stmt.bindLong(1, fileID);
        }
        stmt.bindLong(2, entity.getParentID());
 
        Long childId = entity.getChildId();
        if (childId != null) {
            stmt.bindLong(3, childId);
        }
        stmt.bindString(4, entity.getFileName());
        stmt.bindString(5, entity.getUserName());
        stmt.bindString(6, entity.getDate());
        stmt.bindLong(7, entity.getFileMax());
    }

    @Override
    protected final void attachEntity(FileContent entity) {
        super.attachEntity(entity);
        entity.__setDaoSession(daoSession);
    }

    @Override
    public Long readKey(Cursor cursor, int offset) {
        return cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0);
    }    

    @Override
    public FileContent readEntity(Cursor cursor, int offset) {
        FileContent entity = new FileContent( //
            cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0), // fileID
            cursor.getLong(offset + 1), // parentID
            cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2), // childId
            cursor.getString(offset + 3), // fileName
            cursor.getString(offset + 4), // userName
            cursor.getString(offset + 5), // date
            cursor.getInt(offset + 6) // FileMax
        );
        return entity;
    }
     
    @Override
    public void readEntity(Cursor cursor, FileContent entity, int offset) {
        entity.setFileID(cursor.isNull(offset + 0) ? null : cursor.getLong(offset + 0));
        entity.setParentID(cursor.getLong(offset + 1));
        entity.setChildId(cursor.isNull(offset + 2) ? null : cursor.getLong(offset + 2));
        entity.setFileName(cursor.getString(offset + 3));
        entity.setUserName(cursor.getString(offset + 4));
        entity.setDate(cursor.getString(offset + 5));
        entity.setFileMax(cursor.getInt(offset + 6));
     }
    
    @Override
    protected final Long updateKeyAfterInsert(FileContent entity, long rowId) {
        entity.setFileID(rowId);
        return rowId;
    }
    
    @Override
    public Long getKey(FileContent entity) {
        if(entity != null) {
            return entity.getFileID();
        } else {
            return null;
        }
    }

    @Override
    public boolean hasKey(FileContent entity) {
        return entity.getFileID() != null;
    }

    @Override
    protected final boolean isEntityUpdateable() {
        return true;
    }
    
    /** Internal query to resolve the "fileContentList" to-many relationship of Construction. */
    public List<FileContent> _queryConstruction_FileContentList(Long parentID) {
        synchronized (this) {
            if (construction_FileContentListQuery == null) {
                QueryBuilder<FileContent> queryBuilder = queryBuilder();
                queryBuilder.where(Properties.ParentID.eq(null));
                queryBuilder.orderRaw("T.'DATE' ASC");
                construction_FileContentListQuery = queryBuilder.build();
            }
        }
        Query<FileContent> query = construction_FileContentListQuery.forCurrentThread();
        query.setParameter(0, parentID);
        return query.list();
    }

}
