package com.testy.qrscannernotes;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class QrDetailAdapter extends ArrayAdapter<QrBeanModel> {
    List<QrBeanModel> QrObject;
    public QrDetailAdapter(Context context, int resource,List<QrBeanModel> objects) {
        super(context, resource, objects);
        this.QrObject = objects;
    }

    public void remove(int position) {
        QrBeanModel qrBeanModel = getItem(position);
        qrBeanModel.getQrText();
        QrObject.remove(position);
        //Toast.makeText(getContext(),"Clicked  " + qrBeanModel.getSpecDate(),Toast.LENGTH_LONG).show();
        MainActivity.sendUniqueKey(qrBeanModel.getSpecDate());
        notifyDataSetChanged();
    }

    @Override
    public View getView(int position,View convertView,ViewGroup parent) {
        convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.qr_list_items,parent,false);
        TextView qrText = convertView.findViewById(R.id.qrText);
        TextView qrDate = convertView.findViewById(R.id.qrDate);
        QrBeanModel qrBeanModel = getItem(position);
        qrText.setText(qrBeanModel.getQrText());
        qrDate.setText(qrBeanModel.getDate());
        return convertView;
    }
}
