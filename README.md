# Alfabe Dönüştürücü (Multi-Alphabet Converter) 

Bu proje; Latin, Göktürk (Rünik), Kiril ve Osmanlı alfabeleri arasında çift yönlü metin dönüşümü sağlayan, temiz mimari ve nesne yönelimli programlama (OOP) prensipleriyle tasarlanmış, **gelişime ve katkıya açık (v1.0 MVP) bir Android uygulamasıdır.**

##  Projenin Motivasyonu (Tarihsel ve Kültürel Miras)
Bu uygulamadaki alfabe seçimleri rastgele yapılmamıştır. Uygulama, Türk dilinin tarih boyunca ve günümüzde en çok kullandığı, kültürel ve edebi mirasını şekillendiren 4 ana yazı sistemini kapsayacak şekilde özel olarak tasarlanmıştır:
* **Göktürk (Rünik):** Türk dilinin bilinen ilk yazılı belgeleri olan Orhun Yazıtları'nın kadim alfabesi.
* **Osmanlı (Arap tabanlı):** Altı asrı aşkın bir süre boyunca imparatorluğun edebiyat, tarih ve bürokrasisinde kullandığı yazı sistemi.
* **Kiril:** Orta Asya ve Kafkasya'daki birçok Türk cumhuriyeti ve topluluğu tarafından tarihsel ve güncel olarak kullanılan alfabe.
* **Latin:** Modern Türkiye Cumhuriyeti'nin kullandığı ve günümüzde Türk dünyasında ortaklaşa benimsenen çağdaş yazı sistemi.

---

##  Yazılım Mimarisi ve Tasarım Desenleri
Proje, gelecekteki geliştirmelere (yeni alfabeler ve yapay zeka entegrasyonları) esnek bir zemin hazırlamak adına ölçeklenebilir bir mimariyle kurgulanmıştır:

* **Strategy Pattern:** Dönüşüm algoritmaları arayüzden (UI) tamamen soyutlanmıştır. Her alfabenin kuralları bağımsız sınıflarda yönetilir.
* **Factory Pattern:** `TranslatorFactory` sınıfı, kullanıcının seçimine göre çalışma zamanında (runtime) doğru dönüşüm stratejisini dinamik olarak üretir.
* **Merkez (Hub-and-Spoke) Mimarisi:** Her alfabeden diğerine doğrudan dönüşüm yazmak (N x N karmaşıklığı) yerine **Latin Alfabesi merkezi bir köprü (Pivot)** olarak konumlandırılmıştır. Örneğin Kiril'den Osmanlıca'ya çeviri yapılırken, metin önce `KirilToLatinStrategy` ile normalize edilir, ardından `LatinToOsmanliStrategy` sınıfına beslenir. Bu sayede modüller arası bağımlılık en aza indirilmiştir.

---

##  Gelecek Planları ve Yol Haritası (Roadmap)
Bu proje statik bir son ürün değil, yaşayan bir altyapı olarak kurgulanmıştır. İlerleyen sürümlerde sisteme entegre edilmesi planlanan özellikler:

* **Bağlamsal ve Tarihsel Çeviri:** Yalnızca karakter/harf tabanlı ("lossy") dönüşümden çıkarak, kelimenin tarihsel bağlamını anlayan NLP (Doğal Dil İşleme) modellerinin entegrasyonu.
* **Yeni Dil Aileleri:** Merkez (Hub) mimarisinin sunduğu kolaylık sayesinde, sisteme yeni tarihi ve bölgesel alfabelerin eklenmesi.
* **Kamera ile Metin Tarama (OCR):** Basılı tarihi metinlerin kameradan okunarak anında güncel alfabeye dönüştürülmesi.

---

##  Proje Klasör Yapısı

```text
AlfabeDonusturucu/
├── app/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/com/example/alphabetconverter/
│   │   │   │   ├── MainActivity.java             # Arayüz Kontrolcüsü
│   │   │   │   ├── TranslatorFactory.java        # Strateji Üretim Fabrikası
│   │   │   │   ├── TranslationStrategy.java      # Ana Ortak Arayüz (Interface)
│   │   │   │   │
│   │   │   │   └── strategies/                   # Dönüşüm Algoritmaları
│   │   │   │       ├── GokturkToLatinStrategy.java
│   │   │   │       ├── KirilToLatinStrategy.java
│   │   │   │       ├── LatinToGokturkStrategy.java
│   │   │   │       ├── LatinToKirilStrategy.java
│   │   │   │       ├── LatinToOsmanliStrategy.java
│   │   │   │       └── OsmanliToLatinStrategy.java
│   │   │   │
│   │   │   └── res/                              # Tasarımlar ve Logolar
│   │   │
│   │   └── test/java/com/example/alphabetconverter/
│   │       └── ExampleUnitTest.java              # Merkez Mimari Testleri
└── README.md
```

##  Kullanılan Teknolojiler
* **Dil:** Java

* **Geliştirme Ortamı:** Android Studio

* **Minimum SDK:** Android 8.0 (API 26)

##  Kurulum
Uygulamanın v1.0 MVP sürümünü test etmek için Releases bölümünden .apk dosyasını doğrudan Android cihazınıza indirebilirsiniz.
