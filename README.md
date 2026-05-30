[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-22041afd0340ce965d47ae6ef1cefeee28c7c493a6346c4f15d667ab976d596c.svg)](https://classroom.github.com/a/gqNSK9vH)
# INSTITUT TEKNOLOGI DEL
## UJIAN AKHIR SEMESTER
**Semester IV, T.A. 2025/2026**

| Informasi | Keterangan |
| :--- | :--- |
| **Hari, Tanggal** | Mei 2026 |
| **Kode/ Nama Mata Kuliah** | 12S2203/Pemrograman Berorientasi Objek |
| **Tipe Ujian** | Praktikum |
| **Waktu Pengerjaan** | 240 Menit |
| **Pengajar** | CHP, AMS |

---

## Petunjuk Umum
* Ujian dikerjakan secara individual.
* Ujian bersifat terbuka(local source). Anda tidak diperkenankan untuk mengakses internet selama pengerjaan.
* Perangkat ujian(Laptop) harus dalam mode pesawat, dan non aktifkan WiFi.
* Tidak diperkenankan untuk *sharing* pekerjaan dengan mahasiswa manapun. Pekerjaan dengan tingkat kemiripan >80% dipandang sebagai plagiasi.
* Setiap tindak kecurangan akan diproses sesuai dengan aturan yang berlaku. Integritas *source code* akan diperiksa dengan menggunakan JPlag.
* Submission dan video presentasi anda akan berkontribusi sebesar 60% pada nilai akhir UAS.

## Pengumpulan
1. Penilaian dan pengumpulan dilakukan secara otomatis menggunakan GitHub Classroom.
2. Setelah *submission deadline*, presentasikan pekerjaan anda dengan merekam layar (*full screen*) dan wajah anda.
* Video harus menunjukkan wajah dan layar penuh.  
* Jabarkan rationale implementasi, alir eksekusi, demonstrasi program, dan buktikan hasil di GitHub Classroom.
* Presentasikan pekerjaan anda dalam video minimal 10 menit (1080p).  
3. Upload video ke YouTube dengan *public*.
4. Kirimkan link video melalui Google Form yang ditentukan paling lama pada hari berikutnya pukul 08.00 WIB.

---

## F01 Park-IT
Pada sesi ini anda diminta untuk menyelesaikan sebuah persoalan untuk menguji pengetahuan serta keterampilan anda dalam menerapkan berbagai konsep yang telah dipelajari.

### Case Study
Di Institut Teknologi Del, penataan lokasi parkir kendaraan sivitas akademika menjadi prioritas. Setiap kendaraan harus diparkirkan pada area yang telah ditentukan sesuai dengan jenis kendaraannya. Terdapat beberapa area parkir yang dikhususkan untuk mobil (*car*) dan sepeda motor (*motorcycle*). Berikut adalah ketentuan yang diterapkan:
* Mobil (*car*) hanya dapat diparkirkan pada area parkir yang dikhususkan untuk mobil. Begitu pula dengan sepeda motor (*motorcycle*).
* Penempatan kendaraan ke dalam area parkir tidak boleh melebihi kapasitas yang tersedia.
* Kendaraan (*vehicle*) diidentifikasi dengan atribut: nomor polisi/plat (`plate_number`), nama pemilik (`owner`), dan jenis kendaraan (`type`). Keunikan kendaraan dijamin melalui `plate_number`.
* Area parkir (`parking_area`) diidentifikasi dengan: nama area (`name`), kapasitas maksimal (`capacity`), dan jenis kendaraan yang diizinkan (`allowed_type`). Keunikan area parkir dijamin melalui `name`.

### Codebase
Mensimulasikan studi kasus dalam solusi berbasis Java dengan mengaplikasikan konsep OO dan ORM berbasis JPA. Seluruh data disimpan pada database persisten. Anda dibebaskan menggunakan *driver database* (H2, MySQL, PostgreSQL, dsb.) sesuai pilihan masing-masing.

Pada *repository* telah disediakan:
* `pom.xml`: Tambahkan dependensi driver database yang Anda pilih. Ubah `groupId` pada pom.xml menjadi Nomor Induk Mahasiswa (NIM) anda.
* `persistence.xml`: Konfigurasi ulang (JDBC URL, Driver Class, kredensial) sesuai database Anda.
* `pbo.f01.App`: Driver class utama.

---

## Tugas & Penilaian

### 1. Database Design (20 Poin)
Gambarkan struktur basisdata yang sesuai dalam diagram Physical Data Model (PDM). *(Dinilai secara manual).*

### 2. Entity Definition (20 Poin)
Kembangkan entity classes yang representatif. Definisikan mapping menggunakan annotation atau `persistence.xml`. *(Dinilai secara manual).*

### 3. Register Entities (20 Poin)
Fitur penambahan data kendaraan dan area parkir melalui STDIN.
* Format Area: `area-add#<name>#<capacity>#<allowed_type>`
* Format Kendaraan: `vehicle-add#<plate_number>#<owner>#<type>`

### 4. Assigning Vehicle (20 Poin)
Fitur menempatkan kendaraan ke area parkir. Validasi kapasitas dan jenis kendaraan.
* Format: `park#<plate number>#<area name>`

### 5. Display All (20 Poin)
Menampilkan data area parkir (asc by name) dan kendaraan di dalamnya (asc by plate).

---

## Contoh Interaksi I/O

**Input:**
```text
area-add#Area GD722#10#motorcycle
area-add#Area Rektorat#5#car
vehicle-add#BK1234AB#Chandro Pardede#car
vehicle-add#BB9988XY#Budi Santoso#motorcycle
vehicle-add#B123CD#Andi Wijaya#car
park#BK1234AB#Area Rektorat
park#B123CD#Area Rektorat
park#BB9988XY#Area GD722
display-all
```

**Output:**
```text
Area GD722 motorcycle 10|1
BB9988XY Budi Santoso motorcycle
Area Rektorat car 5|2
B123CD Andi Wijaya car
BK1234AB Chandro Pardede car
```