package com.ahmetsudeys.fiyatdedektifi;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button button;
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private ArrayList<Product> productList = new ArrayList<>();  // ArrayList<Product> olarak güncellendi
    private ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = findViewById(R.id.editText);
        button = findViewById(R.id.button);
        recyclerView = findViewById(R.id.recyclerView);

        // RecyclerView için layout manager ayarı
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Butona tıklandığında veri getirme işlemi başlatılır
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String searchQuery = editText.getText().toString().trim();

                if (!searchQuery.isEmpty()) {
                    // Ürün ismi ile veri çekme işlemini başlat
                    new FetchDataTask(searchQuery).execute();
                } else {
                    Toast.makeText(MainActivity.this, "Lütfen bir ürün ismi giriniz!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    // AsyncTask ile arka planda veri çekme işlemi
    private class FetchDataTask extends AsyncTask<Void, Void, Void> {

        private String searchQuery;

        public FetchDataTask(String searchQuery) {
            this.searchQuery = searchQuery;
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();

            // İşlem başlamadan önce bir progress dialog gösterelim
            progressDialog = new ProgressDialog(MainActivity.this);
            progressDialog.setMessage("Veriler yükleniyor...");
            progressDialog.setCancelable(false);
            progressDialog.show();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            try {
                // Arama URL'sini kullanarak veri çekme işlemi
                Document doc = Jsoup.connect("https://www.gelsineve.com/aramasonuc?search=" + searchQuery).get();

                // Ürün adlarını seç
                Elements productNames = doc.select("div.urunaciklamaGenel.urunAciklama h3 a");

                // Ürün fiyatlarını seç
                Elements newPrices = doc.select("div.new-price");

                // Ürün resimlerini seç
                Elements productImages = doc.select("div.product-image div.image img");

                // Önce listeyi temizle
                productList.clear();

                // Tüm ürün bilgilerini listeye ekle
                for (int i = 0; i < productNames.size(); i++) {
                    String productName = productNames.get(i).text();
                    String newPrice = newPrices.get(i).text();
                    String productImageUrl = productImages.get(i).attr("src");

                    // Her ürün için bir Product nesnesi oluştur
                    Product product = new Product(productName, newPrice, productImageUrl);

                    // Ürünü listeye ekle
                    productList.add(product);
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            progressDialog.dismiss();

            // Verileri RecyclerView'da gösterelim
            adapter = new ProductAdapter(MainActivity.this, productList);  // ArrayList<Product> kullanıyoruz
            recyclerView.setAdapter(adapter);
        }
    }
}
