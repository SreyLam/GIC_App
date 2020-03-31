package com.example.drawnavigation.adapters;

//public class PartnershipAdapter extends RecyclerView.Adapter<PartnershipAdapter.ViewHolder> {
////    private ArrayList newList;
//    private RequestQueue mQueue;
//    private VolleySingleton volleySingleton;
//    private ImageLoader mImageLoader;
//    private Context ctx;
//
//    private ArrayList<SeminarModel> dataList;
//
//    public PartnershipAdapter(ArrayList<SeminarModel> data)
//
//    {
//        this.dataList = data;
//        volleySingleton = VolleySingleton.getInstance(ctx);
//        mImageLoader = volleySingleton.getImageLoader();
//    }
//
//    @NonNull
//    @Override
//    public PartnershipAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.partnership_item, parent, false);
//        ViewHolder viewHolder = new ViewHolder(view);
//        return viewHolder;
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
//        final SeminarModel seminarModel = dataList.get(position);
//        holder.seminarname.setText(seminarModel.getName());
//        holder.date.setText(seminarModel.getDatetime());
//        String image = seminarModel.getImage();
//
//        if (image!=null){
//
//            mImageLoader.get(image, new ImageLoader.ImageListener() {
//                @Override
//                public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
//                    holder.mImageView.setImageBitmap(response.getBitmap());
//                }
//
//                @Override
//                public void onErrorResponse(VolleyError error) {
//
//                }
//            });
//        }
//
//         holder.itemView.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                String image = seminarModel.getImgUri();
////                String name = seminarModel.getName();
////                String datail = seminarModel.getDescri();
////                String pubDate = seminarModel.getPubDate();
////
////                Intent intent = new Intent(ctx.getApplicationContext(),DetailsActivity.class);
////                intent.putExtra("TITLE",name);
////                intent.putExtra("IURL",img);
////                intent.putExtra("DESCR",desc);
////                intent.putExtra("DATE",pubDate);pubDate
//
////                ctx.startActivity(intent);
//
//
//
//            }
//        });
//    }
//
//
//
//
//    @Override
//    public int getItemCount() {
//        return 0;
//    }
//
//
//    public class ViewHolder extends RecyclerView.ViewHolder {
//        private ImageView mImageView;
//        private TextView seminarname,date;
//
//        public ViewHolder(View view) {
//            super(view);
//            mImageView = (ImageView)itemView.findViewById(R.id.thumbnail);
//            seminarname = (TextView) itemView.findViewById(R.id.seminar_name);
//            date = (TextView)itemView.findViewById(R.id.datetime);
//        }
//
//
//    }
//}


