package ru.task8.layouts.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.task8.layouts.model.Layout;

public interface LayoutRepository extends JpaRepository<Layout, Long> {}
