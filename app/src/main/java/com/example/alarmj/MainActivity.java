package com.example.alarmj;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Находим кнопки
        Button btnEven = findViewById(R.id.btnEven);
        Button btnOdd = findViewById(R.id.btnOdd);

        // Устанавливаем обработчики нажатия на кнопки
        btnEven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Загружаем EvenFragment при нажатии на кнопку "четная"
                loadFragment(new EvenFragment());
            }
        });

        btnOdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Загружаем OddFragment при нажатии на кнопку "нечетная"
                loadFragment(new OddFragment());
            }
        });
    }

    // Метод для загрузки фрагмента в контейнер
    private void loadFragment(Fragment fragment) {
        // Получаем менеджер фрагментов
        FragmentManager fragmentManager = getSupportFragmentManager();
        // Начинаем транзакцию
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // Заменяем содержимое контейнера фрагментом
        fragmentTransaction.replace(R.id.fragment_container, fragment);
        // Добавляем транзакцию в стек, чтобы можно было вернуться к предыдущему фрагменту при нажатии кнопки "Назад"
        fragmentTransaction.addToBackStack(null);
        // Фиксируем транзакцию
        fragmentTransaction.commit();
    }
}