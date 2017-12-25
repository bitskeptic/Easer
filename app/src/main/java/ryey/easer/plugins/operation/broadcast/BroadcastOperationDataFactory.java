package ryey.easer.plugins.operation.broadcast;

import android.net.Uri;
import android.support.annotation.NonNull;

import java.util.ArrayList;

import ryey.easer.commons.C;
import ryey.easer.commons.IllegalStorageDataException;
import ryey.easer.commons.plugindef.operationplugin.OperationData;
import ryey.easer.commons.plugindef.operationplugin.OperationDataFactory;

class BroadcastOperationDataFactory implements OperationDataFactory {
    @NonNull
    @Override
    public Class<? extends OperationData> dataClass() {
        return BroadcastOperationData.class;
    }

    @NonNull
    @Override
    public OperationData emptyData() {
        return new BroadcastOperationData();
    }

    @NonNull
    @Override
    public OperationData dummyData() {
        BroadcastOperationData dummyData = new BroadcastOperationData();
        IntentData intentData = new IntentData();
        intentData.action = "testAction";
        intentData.category = new ArrayList<>();
        intentData.category.add("testCategory");
        intentData.type = "myType";
        intentData.data = Uri.parse("myprot://seg1/seg2");
        intentData.extras = new ArrayList<>();
        IntentData.ExtraItem extraItem = new IntentData.ExtraItem();
        extraItem.key = "extra_key1";
        extraItem.value = "extra_value1";
        extraItem.type = "string";
        intentData.extras.add(extraItem);
        return dummyData;
    }

    @NonNull
    @Override
    public OperationData parse(@NonNull String data, @NonNull C.Format format, int version) throws IllegalStorageDataException {
        return new BroadcastOperationData(data, format, version);
    }
}
