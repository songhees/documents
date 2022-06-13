package org.zerock.guestbook.service;

import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.dsl.BooleanExpression;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.zerock.guestbook.dto.GuestbookDTO;
import org.zerock.guestbook.dto.PageRequestDTO;
import org.zerock.guestbook.dto.PageResultDTO;
import org.zerock.guestbook.entity.Guestbook;
import org.zerock.guestbook.entity.QGuestbook;
import org.zerock.guestbook.repository.GuestbookRepository;

import java.util.Optional;
import java.util.function.Function;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestbookServiceImpl implements GuestbookService{
    private final GuestbookRepository repository;

    @Override
    public Long register(GuestbookDTO dto) {
        log.info("DTO...........");
        log.info(dto);

        Guestbook entity = dtoToEntity(dto);

        log.info(entity);

        repository.save(entity);
        return entity.getGno();
    }

    @Override
    public PageResultDTO<GuestbookDTO, Guestbook> getList(PageRequestDTO requestDTO) {
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        BooleanBuilder builder = getSearch(requestDTO);
        Page<Guestbook> result = repository.findAll(builder, pageable);

        Function<Guestbook, GuestbookDTO> fn = (entity -> entityToDTO(entity));
        return new PageResultDTO<>(result, fn);
    }

    @Override
    public GuestbookDTO read(Long gno) {
        Optional<Guestbook> result = repository.findById(gno);
        return result.isPresent()? entityToDTO(result.get()) : null;
    }

    @Override
    public void remove(Long gno) {
        repository.deleteById(gno);
    }

    @Override
    public void modify(GuestbookDTO dto) {
        Optional<Guestbook> result = repository.findById(dto.getGno());

        if (result.isPresent()) {
            Guestbook entity = result.get();
            entity.changeContent(dto.getContent());
            entity.changeTitle(dto.getTitle());
            repository.save(entity);
        }
    }

    private BooleanBuilder getSearch(PageRequestDTO requestDTO) {
        QGuestbook qGuestbook = QGuestbook.guestbook;
        BooleanBuilder builder = new BooleanBuilder();

        String type = requestDTO.getType();
        String keyword = requestDTO.getKeyword();
        BooleanExpression expression = qGuestbook.gno.gt(0L);

        builder.and(expression);

        if (type == null || type.trim().length() == 0) {
            return builder;
        }

        BooleanBuilder conditionBuilder = new BooleanBuilder();

        if (type.contains("t")) {
            conditionBuilder.and(qGuestbook.title.contains(keyword));
        }
        if (type.contains("c")) {
            conditionBuilder.and(qGuestbook.content.contains(keyword));
        }
        if (type.contains("w")) {
            conditionBuilder.and(qGuestbook.writer.contains(keyword));
        }

        builder.and(conditionBuilder);
        return builder;

    }
}
