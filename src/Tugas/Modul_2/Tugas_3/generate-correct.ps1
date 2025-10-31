# generate-correct.ps1
Write-Host "=== GENERATE JAVA DOCUMENTATION ===" -ForegroundColor Cyan

$JAVADOC_PATH = "C:\Users\ASUS\.jdks\openjdk-23.0.2\bin\javadoc.exe"
$TARGET_FOLDER = "src/Tugas/Modul_2/Tugas_3"

Write-Host "📁 Target folder: $TARGET_FOLDER" -ForegroundColor Yellow

# Cek file Java
$javaFiles = Get-ChildItem "$TARGET_FOLDER/*.java" -ErrorAction SilentlyContinue

if ($javaFiles.Count -eq 0) {
    Write-Host "❌ File Java tidak ditemukan di $TARGET_FOLDER" -ForegroundColor Red
    exit
}

Write-Host "✓ Ditemukan $($javaFiles.Count) file Java:" -ForegroundColor Green
$javaFiles | ForEach-Object { Write-Host "   - $($_.Name)" -ForegroundColor White }

# Bersihkan dan buat folder docs
if (Test-Path "docs") {
    Remove-Item -Recurse -Force "docs"
    Write-Host "🗑️ Folder docs lama dihapus" -ForegroundColor Yellow
}

New-Item -ItemType Directory -Path "docs" | Out-Null
Write-Host "✓ Folder docs baru dibuat" -ForegroundColor Green

# Generate documentation
Write-Host "`n📚 Generating JavaDoc..." -ForegroundColor Yellow

& $JAVADOC_PATH -d docs `
  -author `
  -version `
  -windowtitle "Train Ticket System Documentation" `
  -doctitle "Train Ticket Management System" `
  -header "Class Documentation" `
  -bottom "Copyright © 2024" `
  -encoding UTF-8 `
  -charset UTF-8 `
  "$TARGET_FOLDER/*.java"

if ($LASTEXITCODE -eq 0) {
    Write-Host "`n🎉 SUKSES! JavaDoc berhasil digenerate!" -ForegroundColor Green
    Write-Host "📁 Lokasi: docs/index.html" -ForegroundColor Cyan

    # Tampilkan file yang dihasilkan
    Write-Host "`n📄 File dokumentasi yang dibuat:" -ForegroundColor Yellow
    Get-ChildItem "docs/*.html" | Select-Object -First 10 | ForEach-Object { Write-Host "   - $($_.Name)" -ForegroundColor White }

    Write-Host "`n🚀 Membuka dokumentasi di browser..." -ForegroundColor Yellow
    Start-Process "docs/index.html"
} else {
    Write-Host "`n❌ Gagal generate dokumentasi! Error code: $LASTEXITCODE" -ForegroundColor Red
    Write-Host "🔧 Mencoba method alternatif..." -ForegroundColor Yellow

    # Method alternatif: specify files individually
    Write-Host "Mencoba dengan file individual..." -ForegroundColor Gray
    $fileList = $javaFiles | ForEach-Object { $_.FullName }
    & $JAVADOC_PATH -d docs -author -version -encoding UTF-8 $fileList

    if (Test-Path "docs/index.html") {
        Write-Host "✓ Berhasil dengan method alternatif!" -ForegroundColor Green
        Start-Process "docs/index.html"
    }
}