package edu.monash.hackamon.spot;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;



public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ViewHolder> {

    private String[] floor = {
            "G","UG","1L","2L"
    };

    private String[] grounds = {
            Integer.toString((int) Math.ceil(Math.random() * 100)) + "%",
            Integer.toString((int) Math.ceil(Math.random() * 100)) + "%",
            Integer.toString((int) Math.ceil(Math.random() * 100)) + "%",
            Integer.toString((int) Math.ceil(Math.random() * 100)) + "%"
    };


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recycler_view,viewGroup, false); //CardView inflated as RecyclerView list item
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final ViewHolder viewHolder, final int position) {
//        viewHolder.itemImage.setImageResource(images[position]);
        viewHolder.floorNum.setText(floor[position]);
        viewHolder.availability.setText(grounds[position]);



        //a class declared in a method (so called local or anonymous class can only access the method's local variables if they are declared final (1.8 or are effectively final)
        //this has to do with Java closures
        // see ht
        final int fPosition = position;
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() { //set back to itemView for students
            @Override public void onClick(View v) {

                //Snackbar.make(v, "Item at position " + fPosition + " was clicked!", Snackbar.LENGTH_LONG).setAction("Action", null).show();
            }
        });


    }

    @Override
    public int getItemCount() {
        return floor.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public View itemView;
        public TextView floorNum;
        public TextView availability;

        public ViewHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;
            floorNum =itemView.findViewById(R.id.floor_num);
            availability = itemView.findViewById(R.id.noti);


        }
    }



}