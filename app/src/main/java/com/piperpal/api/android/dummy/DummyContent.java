package com.piperpal.api.android.dummy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.widget.TextView;

import com.piperpal.api.JSON;
import com.piperpal.api.Location;
import com.piperpal.api.PiperParser;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p/>
 * TODO: Replace all uses of this class before publishing your app.
 */
public class DummyContent {

    /**
     * An array of sample (location) items.
     */
    public static final List<DummyItem> ITEMS = new ArrayList<DummyItem>();

    PiperParser p = new PiperParser();

    /**
     * A map of sample (dummy) items, by ID.
     */
    public static final Map<String, DummyItem> ITEM_MAP = new HashMap<String, DummyItem>();

    private static final int COUNT = 25;

    private JSONObject jsonObject;

    // String strJSONValue = throw

    TextView txtViewParsedValue;

    String strParsedValue = null;

    static {
        // Add some sample items.
        addItem(createDummyItem(1, "Restaurant"));
        addItem(createDummyItem(2, "Bar"));
        addItem(createDummyItem(3, "Concert"));
        addItem(createDummyItem(4, "Film"));
        addItem(createDummyItem(5, "Books"));
        addItem(createDummyItem(6, "Health"));
        addItem(createDummyItem(7, "Clothes"));
        addItem(createDummyItem(8, "Food"));
        addItem(createDummyItem(9, "Music"));
        addItem(createDummyItem(10, "Electronics"));
        addItem(createDummyItem(11, "Transport"));
        addItem(createDummyItem(12, "Rental"));
    }

    private static void addItem(DummyItem item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }

    private static DummyItem createDummyItem(int position, String str) {
        return new DummyItem(String.valueOf(position), str, makeDetails(position, str));
    }

    private static String makeDetails(int position, String str) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about " + str);
        // for (int i = 0; i < position; i++) {
        //     builder.append(str);
       //  }
        return builder.toString();
    }

    /**
     * A dummy item representing a piece of content.
     */
    public static class DummyItem {
        public final String id;
        public final String content;
        public final String details;

        public DummyItem(String id, String content, String details) {
            this.id = id;
            this.content = content;
            this.details = details;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
